package com.quizmasterdeluxe.platform.exception;

public enum QuizMasterExceptionType {
    PAGE_NOT_FOUND("404","page not found");
    private String code;
    private String message;

     QuizMasterExceptionType(String code, String message) {
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
