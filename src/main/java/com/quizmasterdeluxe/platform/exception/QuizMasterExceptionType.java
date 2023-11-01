package com.quizmasterdeluxe.platform.exception;

public class QuizMasterExceptionType {
    private String code;
    private String message;

    public QuizMasterExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
