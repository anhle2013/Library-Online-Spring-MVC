package com.cg.model;

public enum BorrowStatus {
    BORROWING("borrowing"),
    DONE("done"),
    OUT_OF_DATE("out of date"),
    LOST("lost");

    private final String value;

    BorrowStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static BorrowStatus getEnum(String value) {
        BorrowStatus[] values = values();
        for (BorrowStatus status : values) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new IllegalArgumentException("Invalid: " + value);
    }
}
