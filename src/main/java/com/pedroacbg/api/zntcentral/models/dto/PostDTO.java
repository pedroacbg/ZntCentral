package com.pedroacbg.api.zntcentral.models.dto;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.pedroacbg.api.zntcentral.models.Post;
import com.pedroacbg.api.zntcentral.models.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Cannot be emtpy")
    private String text;
    private Instant postDate;
    private Long userId;

    private Set<ReplyDTO> replies = new HashSet<>();

    public PostDTO(Post entity){
        id = entity.getId();
        text = entity.getText();
        postDate = entity.getPostDate();
        userId  = entity.getUser().getId();
        entity.getReplies().forEach(reply -> this.replies.add(new ReplyDTO(reply)));
    }
}
