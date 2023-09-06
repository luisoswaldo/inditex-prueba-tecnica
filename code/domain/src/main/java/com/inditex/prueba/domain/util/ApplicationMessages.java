package com.inditex.prueba.domain.util;

public enum ApplicationMessages {

    BD_ACCESS_ERROR(5001, "Error trying to access the database."),
    RECORD_NOT_FOUND(4004, "Record not found"),
    VALIDATE_FILED_ERROR(4000, "Required fields %s."),
    DATE_NOT_PARSED(4001, "Date could not be parsed");

    private final int code;

    private final String message;

    ApplicationMessages(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
