package com.pedroacbg.api.zntcentral.models.dto;

import com.pedroacbg.api.zntcentral.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public RoleDTO(Role entity){
        id = entity.getId();
        authority = entity.getAuthority();
    }
}
