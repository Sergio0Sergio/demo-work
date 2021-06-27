package com.example.demo.repository;

import com.example.demo.model.MyCalendarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

@Repository
public class JdbcMyCalendarRepository implements MyCalendarRepository{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    private void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("cntr_m2")
                .withProcedureName("f_get_year")
                .declareParameters(
                        new SqlParameter("p_id_year_in", Types.INTEGER))
                .withoutProcedureColumnMetaDataAccess()
                .returningResultSet("calendars",
                        BeanPropertyRowMapper.newInstance(MyCalendarDto.class));
    }

    @Override
    public List<MyCalendarDto> findMyCalendars(Integer id) {


        Map out = simpleJdbcCall.execute(new MapSqlParameterSource().addValue("p_id_year_in", id));
        if (out == null){
            return Collections.emptyList();
        }
        return  (List) out.get("calendars");
    }
}
