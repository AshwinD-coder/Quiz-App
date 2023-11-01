package com.quizmasterdeluxe.usecase.quizfilter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuizFilterResponse {



    @JsonIgnoreProperties("name")
    private String name;


    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("results")
    private List<QuizFilterResult> resultsList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<QuizFilterResult> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<QuizFilterResult> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public String toString() {
        return "QuizFilterResponse{" +
                "name='" + name + '\'' +
                ", responseCode=" + responseCode +
                ", resultsList=" + resultsList +
                '}';
    }
}
