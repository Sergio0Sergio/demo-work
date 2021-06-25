package com.example.demo.controller;

import com.example.demo.model.MessageDto;
import com.example.demo.service.HelloService;
import com.example.demo.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    private HelloService helloService;

    @Autowired
    public HelloController(HelloServiceImpl helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public ResponseEntity<MessageDto> getMessage() {
        MessageDto message = helloService.getMessage();
        return ResponseEntity.ok(message);
    }
}