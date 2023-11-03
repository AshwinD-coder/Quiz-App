package com.quizmasterdeluxe.platform.exception;

public class QuizMasterException extends RuntimeException {
    QuizMasterExceptionType type;


    public QuizMasterExceptionType getType() {
        return type;
    }

    public void setType(QuizMasterExceptionType type) {
        this.type = type;
    }

    public QuizMasterException(QuizMasterExceptionType type) {
        super(type.getMessage());
        this.type = type;

    }
}
