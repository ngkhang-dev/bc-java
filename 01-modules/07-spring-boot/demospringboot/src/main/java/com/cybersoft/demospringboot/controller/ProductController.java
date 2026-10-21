package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.dto.DatabaseDTO;
import com.cybersoft.demospringboot.request.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("db1")
    private DatabaseDTO databaseDTO;

    @GetMapping
    public ResponseEntity<?> getListOfProduct(@RequestParam String keyWord, @RequestParam int pageNum) {

        System.out.println("DB Username: " + databaseDTO.getUsername() + "");
        databaseDTO.setUsername(keyWord);

        return ResponseEntity.ok(databaseDTO);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestParam String productName, @RequestParam double price) {
        return ResponseEntity.ok("Them san pham thanh cong: " + productName + " - " + price);
    }

    @PostMapping("/json")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest updateProduct) {
        return ResponseEntity.ok(updateProduct);
    }
}
