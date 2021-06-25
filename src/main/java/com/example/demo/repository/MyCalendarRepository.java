package com.example.demo.repository;

import com.example.demo.model.MyCalendarDto;

import java.util.List;


public interface MyCalendarRepository {

    List<MyCalendarDto> findMyCalendars(Integer id);

}
