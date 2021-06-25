package com.example.demo.controller;

import com.example.demo.model.MyCalendarDto;
import com.example.demo.service.MyCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private MyCalendarService myCalendarService;


    @Autowired
    public CalendarController(MyCalendarService myCalendarService){
        this.myCalendarService = myCalendarService;
    }

    @GetMapping
    public ResponseEntity<List<MyCalendarDto>> getCalendars(@RequestParam Integer id){
         List<MyCalendarDto> result = myCalendarService.getCalendar(id);
        return ResponseEntity.ok(result);
    }
}
