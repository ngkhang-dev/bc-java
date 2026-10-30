package com.cybersoft.demojpa.service;

import com.cybersoft.demojpa.dto.RoleDTO;
import com.cybersoft.demojpa.request.InsertRoleRequest;
import com.cybersoft.demojpa.request.UpdateRoleRequest;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAllRoles();
    RoleDTO insertRole(InsertRoleRequest request);
    RoleDTO updateRole(UpdateRoleRequest request);
}
