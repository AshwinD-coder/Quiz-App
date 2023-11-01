package com.quizmasterdeluxe.usecase.quizfilter;

public class QuizFilterRequest {
    private String difficulty;
    private String category;

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

    @Override
    public String toString() {
        return "QuizFilter{" +
                "difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
