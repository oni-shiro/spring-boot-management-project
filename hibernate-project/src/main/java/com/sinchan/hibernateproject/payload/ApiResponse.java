package com.sinchan.hibernateproject.payload;

public class ApiResponse {

    private String message;
    private String status;

    public ApiResponse() {
    }

    public ApiResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
