package com.cybersoft.uniclub14.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @PostMapping
  public ResponseEntity<?> insertProduct() {
    return ResponseEntity.ok("Insert Product");
  }
}
