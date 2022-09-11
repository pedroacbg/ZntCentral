package com.pedroacbg.api.zntcentral.models.dto;

import com.pedroacbg.api.zntcentral.models.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Cannot be empty")
    private String text;

    public ReplyDTO(Reply entity){
        id = entity.getId();
        text = entity.getText();
    }
}
