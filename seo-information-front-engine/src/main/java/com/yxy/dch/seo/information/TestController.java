package com.yxy.dch.seo.information;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("/channel")
    public String channel(){
        return "channel";
    }
}
