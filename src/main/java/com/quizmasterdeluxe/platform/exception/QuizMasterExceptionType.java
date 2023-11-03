package com.quizmasterdeluxe.platform.exception;

public enum QuizMasterExceptionType {
     ATLEAST_ONE_ANSWER( "400","No Answer was submitted" );
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
