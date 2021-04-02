package ru.romankuznetsov.dto;

public class ErrorDto {
    private String message;

    public ErrorDto() {
    }

    public String getMessage() {
        return message;
    }

    public ErrorDto(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
