package com.quizmasterdeluxe.usecase.quizresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Introspected
@Serdeable
public class QuizResultRequest {


    @JsonProperty
     private Map<String , String> questionAnswer;

    public QuizResultRequest(Map<String, String> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Map<String, String> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Map<String, String> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Override
    public String toString() {
        return "QuizResultRequest{" +
                "questionAnswer=" + questionAnswer +
                '}';
    }
}
