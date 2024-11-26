package com.blsystem.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
public enum BloodStatus {
    RESERVED("Reserved"),
    AVAILABLE("Available"),
    IN_USE("In Use"),
    EXPIRED("Expired");

    private String value;

    BloodStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BloodStatus fromValue(String value) {
        for (BloodStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid BloodStatus value: " + value);
    }

    @JsonValue
    public String toValue() {
        return value;
    }
}
