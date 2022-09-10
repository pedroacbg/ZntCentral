package com.pedroacbg.api.zntcentral.models.dto;

import com.pedroacbg.api.zntcentral.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nickname;

    public UserDTO(User entity){
        id = entity.getId();
        nickname = entity.getNickname();
    }

}
