package com.morgan.spring.batch;

import com.morgan.spring.dto.AddressDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AddressReader {

    final String query = "SELECT id, city, nation FROM address order by city asc";

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemReader<AddressDTO> reader(){
        return new JdbcCursorItemReaderBuilder<AddressDTO>()
                .name("Address Reader")
                .dataSource(dataSource)
                .sql(query)
                .rowMapper(new BeanPropertyRowMapper<>(AddressDTO.class))
                .build();
    }
}
