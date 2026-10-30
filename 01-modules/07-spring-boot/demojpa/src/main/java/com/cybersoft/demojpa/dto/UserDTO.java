package com.cybersoft.demojpa.dto;

import com.cybersoft.demojpa.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String username;

    public static UserDTO mapToDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());

        return dto;
    }
}
