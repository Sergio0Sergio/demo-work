package com.example.demo.service;

import com.example.demo.model.MyCalendarDto;
import com.example.demo.procedures.StoredProcedure;
import com.example.demo.repository.MyCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyCalendarService {

    @Autowired
    private StoredProcedure storedProcedure;

    @Autowired
    private MyCalendarRepository myCalendarRepository;

    @Transactional
    public List<MyCalendarDto> getCalendar(Integer id){
        return myCalendarRepository.findMyCalendars(id);
    }
}
