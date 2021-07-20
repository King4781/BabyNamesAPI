package com.kentonking.babynames.ui.response;

import java.time.LocalDateTime;

public class CustomErrorResponse {
    private String status;
    private String message;
    private LocalDateTime date;

    public CustomErrorResponse() { }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
