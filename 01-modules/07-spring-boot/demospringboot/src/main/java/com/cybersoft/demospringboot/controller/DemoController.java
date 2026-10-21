package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.dto.DatabaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    @Qualifier("db1") // Gọi một bean dữa theo tên
    private DatabaseDTO databaseDTO;

    @GetMapping("/v1")
    public String logicCode1 () {
        System.out.println("DB Username: " + databaseDTO.getUsername() + "");
        return "logicCode1";
    }

    @GetMapping("/")
    public String logicCode2 () {
        return "logicCode2";
    }
}
