package com.cybersoft.demospringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/v1")
    public String logicCode1 () {
        return "logicCode1";
    }

    @GetMapping("/")
    public String logicCode2 () {
        return "logicCode2";
    }
}
