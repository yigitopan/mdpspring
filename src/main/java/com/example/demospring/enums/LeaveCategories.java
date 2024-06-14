package com.example.demospring.enums;

public enum LeaveCategories {
    HOURLY(1),
    DAILY(2);

    private final int value;

    LeaveCategories(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
