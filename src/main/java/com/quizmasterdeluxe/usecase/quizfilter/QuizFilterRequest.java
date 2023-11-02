package com.quizmasterdeluxe.usecase.quizfilter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quizmasterdeluxe.platform.usecase.UseCaseRequest;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class QuizFilterRequest implements UseCaseRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("category")
    private String category;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public QuizFilterRequest(String name, String difficulty, String category) {
        this.name = name;
        this.difficulty = difficulty;
        this.category = category;
    }

    public QuizFilterRequest() {
    }

    @Override
    public String toString() {
        return "QuizFilterRequest{" +
                "name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
