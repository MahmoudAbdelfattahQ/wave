package com.example.spring3.controller;

import com.example.demo.service.Drive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("drive")
public class DriveController {

    private final Drive drive;

    public DriveController(Drive drive) {
        this.drive = drive;
    }

    @PostMapping("startEngine")
    public void startEngineApi() {
        drive.startEngine();
    }
}
