package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("health")
public class HealthCheckController {

    @GetMapping("health")
    public String healthCheck() {
        return "<h2>I am up and running</h2>";
    }

    @GetMapping("ok")
    public String healthCheckOk() {
        return "<h1>Okay</h1>";
    }

}
