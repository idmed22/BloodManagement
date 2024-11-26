package com.blsystem.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BloodGroup {

    B_NEGATIVE("B-"),
    AB_NEGATIVE("AB-"),
    O_NEGATIVE("O-"),
    B_POSITIVE("B+"),
    A_POSITIVE("A+"),
    O_POSITIVE("O+"),
    A_NEGATIVE("A-"),
    AB_POSITIVE("AB+");

    private String value;

    BloodGroup(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static BloodGroup fromValue(String value) {
        for (BloodGroup bloodGroup : BloodGroup.values()) {
            if (bloodGroup.value.equalsIgnoreCase(value)) {
                return bloodGroup;
            }
        }
        throw new IllegalArgumentException("Unknown BloodGroup value: " + value);
    }
}

