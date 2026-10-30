package com.cybersoft.demojpa.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDTO {
    private int id;
    private String name;
    private List<UserDTO> users;

}
