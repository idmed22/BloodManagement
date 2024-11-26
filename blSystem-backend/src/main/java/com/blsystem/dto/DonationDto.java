package com.blsystem.dto;

import com.blsystem.entity.Donor;
import com.blsystem.entity.Recipient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {
    private Long id;
    private Donor donor;
    private Recipient recipient;
    private String donationDate;
//    private String donationType; // Whole blood, plasma, etc. // enum ?
}
