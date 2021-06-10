package com.yhs.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data", "heelo!!");
        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMve(@RequestParam("name") String name, Model model) {

        model.addAttribute("name", name);
        return "hello-template";

    }

    //템플릿엔진을 거치지 않고 return
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello1" + name;

    }

}
