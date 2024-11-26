package com.blsystem.dto;

import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDto {
    private Long id;
    private String name;
    private Gender gender;
    private int age;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date benefitDate;
    private BloodGroup bloodGroup;
    private String contactNumber;
    private boolean isUrgent;
}
