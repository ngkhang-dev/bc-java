package com.cybersoft.demojpa.service.imp;

import com.cybersoft.demojpa.dto.RoleDTO;
import com.cybersoft.demojpa.dto.UserDTO;
import com.cybersoft.demojpa.entity.RoleEntity;
import com.cybersoft.demojpa.repository.RoleRepository;
import com.cybersoft.demojpa.request.InsertRoleRequest;
import com.cybersoft.demojpa.request.UpdateRoleRequest;
import com.cybersoft.demojpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRoles() {

        List<RoleEntity> roles = roleRepository.findAll();

        return roles
                .stream()
                .map(role -> {
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setId(role.getId());
                    roleDTO.setName(role.getName());
                    roleDTO.setUsers(role.getUsers()
                            .stream()
                            .map(UserDTO::mapToDTO)
                            .toList()
                    );

                    return roleDTO;
                })
                .toList();
    }

    @Override
    public RoleDTO insertRole(InsertRoleRequest request) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(request.getName());

        RoleEntity roleInserted = roleRepository.save(roleEntity);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(roleInserted.getId());
        roleDTO.setName(roleInserted.getName());

        return roleDTO;
    }

    @Override
    public RoleDTO updateRole(UpdateRoleRequest request) {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId(request.getId());
        roleEntity.setName(request.getName());

        RoleEntity roleUpdated = roleRepository.save(roleEntity);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(roleUpdated.getId());
        roleDTO.setName(roleUpdated.getName());

        return roleDTO;
    }
}
