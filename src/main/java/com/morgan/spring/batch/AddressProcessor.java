package com.morgan.spring.batch;

import com.morgan.spring.dto.AddressDTO;
import com.morgan.spring.dto.AddressHistoryDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class AddressProcessor implements ItemProcessor<AddressDTO, AddressHistoryDTO> {
    @Override
    public AddressHistoryDTO process(AddressDTO addressDTO) throws Exception {
        return new AddressHistoryDTO(addressDTO.getId(), addressDTO.getCity(), addressDTO.getNation());
    }
}
