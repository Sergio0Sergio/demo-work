package com.example.demo.service;

import com.example.demo.model.MessageDto;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    public MessageDto getMessage(){
        return new MessageDto("Hello");
    }
}
