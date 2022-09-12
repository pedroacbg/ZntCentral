package com.pedroacbg.api.zntcentral.services;

import com.pedroacbg.api.zntcentral.models.Reply;
import com.pedroacbg.api.zntcentral.models.dto.ReplyDTO;
import com.pedroacbg.api.zntcentral.respositories.PostRepository;
import com.pedroacbg.api.zntcentral.respositories.ReplyRepository;
import com.pedroacbg.api.zntcentral.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<ReplyDTO> findAll(Long postId){
        List<Reply> list = replyRepository.findReplies(postId);
        return list.stream().map(x -> new ReplyDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ReplyDTO insert(ReplyDTO dto){
        Reply entity = new Reply();
        copyDtoToEntity(dto, entity);
        entity = replyRepository.save(entity);
        return new ReplyDTO(entity);
    }

   @Transactional
    public ReplyDTO update(Long id, ReplyDTO dto){
        try{
            Reply entity = replyRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = replyRepository.save(entity);
            return new ReplyDTO(entity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(ReplyDTO dto, Reply entity) {
        entity.setText(dto.getText());
        entity.setPost(postRepository.getOne(dto.getPostId()));
    }

}
