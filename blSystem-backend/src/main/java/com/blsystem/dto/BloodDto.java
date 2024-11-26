package com.blsystem.dto;

import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.entity.enums.BloodStatus;
import com.blsystem.entity.enums.BloodType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDto {

    private Long id;
    private BloodGroup type;
    private BloodType component;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date collectionDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private BloodStatus status;

}
