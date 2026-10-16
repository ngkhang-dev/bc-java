package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.request.UpdateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<?> getListOfProduct(@RequestParam String keyWord, @RequestParam int pageNum) {
        return ResponseEntity.ok("Danh sach san pham voi keyWord: " + keyWord + " trang " + pageNum);
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
