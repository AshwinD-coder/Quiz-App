package com.quizmasterdeluxe.usecase.quizresult;


import com.quizmasterdeluxe.platform.quizholder.TemporaryHolder;
import com.quizmasterdeluxe.platform.usecase.UseCase;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterUseCase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Singleton
public class QuizResultUseCase implements UseCase<QuizResultRequest, QuizResultResponse> {

    @Override
    public Optional<QuizResultResponse> execute(QuizResultRequest quizResultRequest) {
        Map<String, String> systemQuizResult = prepareSystemQuizResult();

        int score = 0;
        Map<String, String> playerCorrectAnswer = new HashMap<>();
        Map<String, String> playerWrongAnswer = new HashMap<>();

        for (Map.Entry<String, String> entry : systemQuizResult.entrySet()) {
            String question = entry.getKey();
            String correctAnswer = entry.getValue();
            String userAnswer = quizResultRequest.getQuestionAnswer().get(question);
            if ( correctAnswer.equals(userAnswer)) {
                score++;
                playerCorrectAnswer.put(question, correctAnswer);
            } else {
                playerWrongAnswer.put(question, userAnswer);
            }
        }

        return Optional.of(buildQuizResultResponse(score, playerCorrectAnswer, playerWrongAnswer));
    }

    private Map<String, String> prepareSystemQuizResult() {
        Map<String, String> systemQuizResult = new HashMap<>();
        for (QuizFilterResult result : TemporaryHolder.get().resultHolder()) {
            systemQuizResult.put(result.getQuestion(), result.getCorrectAnswer());
        }
        return systemQuizResult;
    }

    private QuizResultResponse buildQuizResultResponse(int score, Map<String, String> playerCorrectAnswer, Map<String, String> playerWrongAnswer) {
        return new QuizResultResponse(
                TemporaryHolder.get().name(),
                score,
                playerCorrectAnswer,
                playerWrongAnswer
        );
    }
}

