package com.blsystem.mappers;

import com.blsystem.dto.BloodDto;
import com.blsystem.entity.Blood;
import org.modelmapper.ModelMapper;

public class BloodMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static BloodDto mapToBloodDto(Blood blood) {
        return modelMapper.map(blood, BloodDto.class);
    }

    public static Blood mapToBlood(BloodDto bloodDto) {
        return modelMapper.map(bloodDto, Blood.class);
    }

}
