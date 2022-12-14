package com.pedroacbg.api.zntcentral.services;

import com.pedroacbg.api.zntcentral.models.Post;
import com.pedroacbg.api.zntcentral.models.Reply;
import com.pedroacbg.api.zntcentral.models.User;
import com.pedroacbg.api.zntcentral.models.dto.PostDTO;
import com.pedroacbg.api.zntcentral.models.dto.ReplyDTO;
import com.pedroacbg.api.zntcentral.respositories.PostRepository;
import com.pedroacbg.api.zntcentral.respositories.ReplyRepository;
import com.pedroacbg.api.zntcentral.respositories.UserRepository;
import com.pedroacbg.api.zntcentral.services.exceptions.DatabaseException;
import com.pedroacbg.api.zntcentral.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public PostDTO findById(Long id){
        User user = authService.authenticated();
        authService.validadeAdmin(user.getId());
        Optional<Post> obj = postRepository.findById(id);
        Post entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PostDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<PostDTO> postsForCurrentUser(Pageable pageable){
        User user = authService.authenticated();
        Page<Post> page = postRepository.findByUser(user, pageable);
        return page.map(x -> new PostDTO(x));
    }

    @Transactional
    public PostDTO insert(PostDTO dto){
        User user = authService.authenticated();
        authService.validadeUserLogged(user.getId());
        Post entity = new Post();
        copyDtoToEntity(dto, entity);
        entity = postRepository.save(entity);
        return new PostDTO(entity);
    }

    @Transactional
    public PostDTO update(Long id, PostDTO dto){
        User user = authService.authenticated();
        authService.validadeSelfOrAdmin(postRepository.getOne(id).getUser().getId());
        try{
            Post entity = postRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = postRepository.save(entity);
            return new PostDTO(entity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id){
        User user = authService.authenticated();
        authService.validadeAdmin(user.getId());
        try{
            postRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Couldn't delete because have other entities related");
        }
    }

    private void copyDtoToEntity(PostDTO dto, Post entity) {
        entity.setText(dto.getText());
        entity.setPostDate(dto.getPostDate());
        entity.setUser(userRepository.getOne(dto.getUserId()));

        entity.getReplies().clear();
        for(ReplyDTO replyDto : dto.getReplies()) {
            Reply reply = replyRepository.getOne(replyDto.getId());
            entity.getReplies().add(reply);
        }
    }

}
