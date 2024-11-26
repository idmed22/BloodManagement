package com.blsystem.dto;

import com.blsystem.entity.Recipient;
import com.blsystem.entity.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private Long id;
    private Long recipientId;
    private String requestDate;
    private BloodGroup bloodGroup;
    private boolean isUrgent;
}
