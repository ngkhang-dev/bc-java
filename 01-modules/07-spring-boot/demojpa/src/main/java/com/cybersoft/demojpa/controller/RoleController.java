package com.cybersoft.demojpa.controller;

import com.cybersoft.demojpa.request.InsertRoleRequest;
import com.cybersoft.demojpa.request.UpdateRoleRequest;
import com.cybersoft.demojpa.response.BaseResponse;
import com.cybersoft.demojpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertRole(@RequestBody InsertRoleRequest request) {

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(roleService.insertRole(request));
        baseResponse.setMessage("Role inserted successfully");

        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping
    public ResponseEntity<BaseResponse> updateRole(@RequestBody UpdateRoleRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setData(roleService.updateRole(request));
        baseResponse.setMessage("Role updated successfully");

        return ResponseEntity.ok(baseResponse);
    }
}
