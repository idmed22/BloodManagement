package com.blsystem.mappers;


import com.blsystem.dto.RequestDto;
import com.blsystem.entity.Request;
import org.modelmapper.ModelMapper;

public class RequestMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static RequestDto mapToRequestDto(Request request) {
        return modelMapper.map(request, RequestDto.class);
    }

    public static Request mapToRequest(RequestDto requestDto) {
        return modelMapper.map(requestDto, Request.class);
    }
}
