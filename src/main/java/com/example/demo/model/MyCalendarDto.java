package com.example.demo.model;

import java.util.Objects;

public class MyCalendarDto {

    private Integer idYear;
    private Integer yearNumber;

    public MyCalendarDto() {
    }

    public Integer getIdYear() {
        return idYear;
    }

    public void setIdYear(Integer idYear) {
        this.idYear = idYear;
    }

    public Integer getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(Integer yearNumber) {
        this.yearNumber = yearNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCalendarDto that = (MyCalendarDto) o;
        return Objects.equals(idYear, that.idYear) && Objects.equals(yearNumber, that.yearNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idYear, yearNumber);
    }

}
