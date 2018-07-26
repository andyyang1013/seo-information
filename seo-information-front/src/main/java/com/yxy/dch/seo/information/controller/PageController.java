package com.yxy.dch.seo.information.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/page")
public class PageController {
    @PostMapping("/")
    public void create(MultipartFile file){
        System.out.println("ininin");
    }
}
