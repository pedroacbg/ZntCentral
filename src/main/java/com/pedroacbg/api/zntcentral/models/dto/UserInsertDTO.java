package com.pedroacbg.api.zntcentral.models.dto;

import lombok.Data;

@Data
public class UserInsertDTO extends UserDTO{
    private static final long serialVersionUID = 1L;

    private String password;

}
