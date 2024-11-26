package com.blsystem.mappers;

import com.blsystem.dto.DonationDto;
import com.blsystem.entity.Donation;
import org.modelmapper.ModelMapper;

public class DonationMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static DonationDto mapToDonationDto(Donation donation) {
        return modelMapper.map(donation, DonationDto.class);
    }

    public static Donation mapToDonation(DonationDto donationDto) {
        return modelMapper.map(donationDto, Donation.class);
    }
}
