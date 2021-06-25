package com.example.demo.repository;

import com.example.demo.model.MyCalendarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.*;

@Repository
public class JdbcMyCalendarRepository implements MyCalendarRepository{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    private void postConstruct(){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("cntr_m2")
                .withProcedureName("f_get_year")
                .returningResultSet("#result-set-1",
                        BeanPropertyRowMapper.newInstance(MyCalendarDto.class));
    }

    @Override
    public List<MyCalendarDto> findMyCalendars(Integer id) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("p_id_year_in", id);

        Map out = simpleJdbcCall.execute(parameters);

        if (out == null){
            return Collections.emptyList();
        }
        return  (List) out.get("#result-set-1");

    }
}
