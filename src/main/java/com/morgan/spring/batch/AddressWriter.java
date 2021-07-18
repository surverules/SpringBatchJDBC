package com.morgan.spring.batch;

import com.morgan.spring.dto.AddressHistoryDTO;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AddressWriter {

    final String sql = "INSERT INTO ADDRESS_HISTORY (ID, CITY, NATION, CHANGEDDATE) VALUES (? ,? , ? ,?)";

    @Autowired
    DataSource dataSource;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public ItemWriter<AddressHistoryDTO> write(){
        JdbcBatchItemWriter<AddressHistoryDTO> batchItemWriter = new JdbcBatchItemWriter<>();
        batchItemWriter.setDataSource(dataSource);
        batchItemWriter.setJdbcTemplate(jdbcTemplate);
        batchItemWriter.setSql(sql);

        ItemPreparedStatementSetter<AddressHistoryDTO> jdbcSetter = new AddressJDBCSetter();
        batchItemWriter.setItemPreparedStatementSetter(jdbcSetter);
        return batchItemWriter;
    }
}
