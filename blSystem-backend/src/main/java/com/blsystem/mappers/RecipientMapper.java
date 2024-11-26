package com.blsystem.mappers;


import com.blsystem.dto.RecipientDto;
import com.blsystem.entity.Recipient;
import org.modelmapper.ModelMapper;

public class RecipientMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static RecipientDto mapToRecipientDto(Recipient recipient) {
        return modelMapper.map(recipient, RecipientDto.class);
    }

    public static Recipient mapToRecipient(RecipientDto recipientDto) {
        return modelMapper.map(recipientDto, Recipient.class);
    }
}
