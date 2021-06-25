package com.example.demo.procedures;

import com.example.demo.model.MyCalendarDto;
import com.example.demo.repository.MyCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class StoredProcedure {

    @Autowired
    @Qualifier("jdbcMyCalendarRepository")
    private MyCalendarRepository myCalendarRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCallRefCursor;

    @PostConstruct
    public void init(){
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("cntr_m2")
                .withProcedureName("f_get_year")
                .returningResultSet("ref", BeanPropertyRowMapper.newInstance(MyCalendarDto.class));

    }

    public List<MyCalendarDto> findMyCalendars(Integer id){
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("p_id_year_in", id);
        Map out = simpleJdbcCallRefCursor.execute(parameters);
        if (out == null){
            return Collections.emptyList();
        }
        return (List) out.get("ref");
    }
}
