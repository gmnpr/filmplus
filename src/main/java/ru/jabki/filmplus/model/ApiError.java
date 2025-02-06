package ru.jabki.filmplus.model;

public class ApiError {

    final boolean success;

    final String message;

    public ApiError(final String message) {
        this.success = false;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}