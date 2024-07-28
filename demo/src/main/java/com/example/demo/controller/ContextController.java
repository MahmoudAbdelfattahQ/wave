package com.example.demo.controller;

import com.example.demo.config.Context;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("context")
public class ContextController {

    @GetMapping("name1")
    public String setName1InContextApi() {
        Context.setName("Lamiaa");
        System.out.println(Context.getName());
        return "Okay";
    }

    @GetMapping("getName1")
    public String getName1InContextApi() {
        System.out.println(Context.getName());
        return Context.getName();
    }

    @GetMapping("name2")
    public String setName2InContextApi() {
        Context.setName("Yossief");
        System.out.println(Context.getName());
        return "Ok";
    }


}
