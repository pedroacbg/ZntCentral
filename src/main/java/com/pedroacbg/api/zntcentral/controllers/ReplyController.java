package com.pedroacbg.api.zntcentral.controllers;

import com.pedroacbg.api.zntcentral.models.dto.ReplyDTO;
import com.pedroacbg.api.zntcentral.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping
    public ResponseEntity<ReplyDTO> insert(@Valid @RequestBody ReplyDTO dto){
        ReplyDTO newEntity = replyService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(newEntity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReplyDTO> update(@PathVariable Long id, @RequestBody ReplyDTO dto){
        ReplyDTO newEntity = replyService.update(id, dto);
        return ResponseEntity.ok().body(newEntity);
    }

}
