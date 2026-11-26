package com.cybersoft.uniclub14.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity(name = "role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @OneToMany(mappedBy = "role")
  private List<UserEntity> users;

}
