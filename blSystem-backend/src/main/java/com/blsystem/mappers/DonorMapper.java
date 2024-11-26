package com.blsystem.mappers;

import com.blsystem.dto.DonorDto;
import com.blsystem.entity.Donor;
import org.modelmapper.ModelMapper;

public class DonorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static DonorDto mapToDonorDto(Donor donor) {
        return modelMapper.map(donor, DonorDto.class);
    }

    public static Donor mapToDonor(DonorDto donorDto) {
        return modelMapper.map(donorDto, Donor.class);
    }
}
