package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping
    public ResponseEntity<List<PostDTO>> getListOfPost() {
        List<PostDTO> postDTOList = new ArrayList<>();

        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Title 1");
        postDTO1.setContent("Content 1");
        postDTO1.setImage("https://images_1.png");

        PostDTO postDTO2 = new PostDTO();
        postDTO2.setTitle("Title 2");
        postDTO2.setContent("Content 2");
        postDTO2.setImage("https://images_2.png");

        postDTOList.add(postDTO1);
        postDTOList.add(postDTO2);

        return ResponseEntity.ok(postDTOList);
    }
}
