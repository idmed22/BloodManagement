package com.blsystem.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BloodType {

    PLASMA("Plasma"),
    RED_CELLS("Red Cells"),
    PLATELETS("Platelets"),
    WHOLE_BLOOD("Whole Blood");

    private final String value;

    BloodType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BloodType fromValue(String value) {
        for (BloodType bloodType : values()) {
            if (bloodType.value.equalsIgnoreCase(value)) {
                return bloodType;
            }
        }
        throw new IllegalArgumentException("Invalid BloodType value: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}




