package com.cybersoft.demojpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity {

    @Id
    private String id;

    private String username;
    private String password;
    private LocalDateTime dob;
    private int age;

    // Không khai báo lại cột FK khi map relationship
    // private int roleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

}
