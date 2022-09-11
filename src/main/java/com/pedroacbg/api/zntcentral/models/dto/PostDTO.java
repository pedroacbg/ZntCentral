package com.pedroacbg.api.zntcentral.models.dto;

import com.pedroacbg.api.zntcentral.models.Post;
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
    private UserDTO user;
    Set<ReplyDTO> replies = new HashSet<>();

    public PostDTO(Post entity){
        id = entity.getId();
        text = entity.getText();
        postDate = entity.getPostDate();
        user  = new UserDTO(entity.getUser());
        entity.getReplies().forEach(reply -> this.replies.add(new ReplyDTO(reply)));
    }

}
