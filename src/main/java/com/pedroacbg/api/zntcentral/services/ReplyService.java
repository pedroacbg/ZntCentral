package com.pedroacbg.api.zntcentral.services;

import com.pedroacbg.api.zntcentral.models.Reply;
import com.pedroacbg.api.zntcentral.models.dto.ReplyDTO;
import com.pedroacbg.api.zntcentral.respositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<ReplyDTO> findAll(Long postId){
        List<Reply> list = replyRepository.findReplies(postId);
        return list.stream().map(x -> new ReplyDTO(x)).collect(Collectors.toList());
    }

}
