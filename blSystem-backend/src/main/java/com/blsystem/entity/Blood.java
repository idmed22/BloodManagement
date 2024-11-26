package com.blsystem.entity;

import com.blsystem.entity.enums.BloodGroup;
import com.blsystem.entity.enums.BloodStatus;
import com.blsystem.entity.enums.BloodType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "bloods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BloodGroup type;
    private BloodType component;
    private Date collectionDate;
    private Date expiryDate;
    private BloodStatus status;

}
