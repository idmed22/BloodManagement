package com.blsystem.entity;

import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.entity.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recipientId;
    private String requestDate;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    private boolean isUrgent;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

}
