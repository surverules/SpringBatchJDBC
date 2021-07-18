package com.morgan.spring.batch;

import com.morgan.spring.dto.AddressHistoryDTO;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AddressJDBCSetter implements ItemPreparedStatementSetter<AddressHistoryDTO> {


    @Override
    public void setValues(AddressHistoryDTO addressHistoryDTO, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, addressHistoryDTO.getId());
        preparedStatement.setString(2,addressHistoryDTO.getCity());
        preparedStatement.setString(3,addressHistoryDTO.getNation());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        preparedStatement.setString(4, format.format(Date.valueOf(addressHistoryDTO.getDate())));
    }
}
