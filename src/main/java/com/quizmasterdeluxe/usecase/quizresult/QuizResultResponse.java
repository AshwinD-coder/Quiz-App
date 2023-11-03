package com.quizmasterdeluxe.usecase.quizresult;

import com.quizmasterdeluxe.platform.usecase.UseCaseResponse;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Map;

@Introspected
@Serdeable
public class QuizResultResponse implements UseCaseResponse {

    private String name;
    private int score;
    private Map<String, String> playerCorrectResult;
    private Map<String, String> playerWrongResult;

    public QuizResultResponse(String name, int score, Map<String, String> playerCorrectResult, Map<String, String> playerWrongResult) {
        this.name = name;
        this.score = score;
        this.playerCorrectResult = playerCorrectResult;
        this.playerWrongResult = playerWrongResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<String, String> getPlayerCorrectResult() {
        return playerCorrectResult;
    }

    public void setPlayerCorrectResult(Map<String, String> playerCorrectResult) {
        this.playerCorrectResult = playerCorrectResult;
    }

    public Map<String, String> getPlayerWrongResult() {
        return playerWrongResult;
    }

    public void setPlayerWrongResult(Map<String, String> playerWrongResult) {
        this.playerWrongResult = playerWrongResult;
    }

    @Override
    public String toString() {
        return "QuizResultResponse{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", playerCorrectResult=" + playerCorrectResult +
                ", playerWrongResult=" + playerWrongResult +
                '}';
    }
}
