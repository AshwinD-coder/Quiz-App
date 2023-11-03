package com.quizmasterdeluxe.converter;

import com.quizmasterdeluxe.usecase.quizresult.QuizResultRequest;

import java.util.Map;

public class MapToQuizResultRequest {
    private MapToQuizResultRequest() {
    }

    public static QuizResultRequest toQuizResultRequest(Map<String, String> userQuestionsAnswers) {
        return new QuizResultRequest(userQuestionsAnswers);
    }
}
