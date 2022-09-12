package com.pedroacbg.api.zntcentral.controllers;

import com.pedroacbg.api.zntcentral.models.dto.PostDTO;
import com.pedroacbg.api.zntcentral.models.dto.ReplyDTO;
import com.pedroacbg.api.zntcentral.services.PostService;
import com.pedroacbg.api.zntcentral.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<PostDTO>> postForCurrentUser(Pageable pageable){
        Page<PostDTO> page = postService.postsForCurrentUser(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<PostDTO> insert(@Valid @RequestBody PostDTO dto){
        PostDTO newEntity = postService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(newEntity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostDTO dto){
        PostDTO newEntity = postService.update(id, dto);
        return ResponseEntity.ok().body(newEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{postId}/replies")
    public ResponseEntity<List<ReplyDTO>> findReplies(@PathVariable Long postId){
        List<ReplyDTO> obj = replyService.findAll(postId);
        return ResponseEntity.ok().body(obj);
    }

}
