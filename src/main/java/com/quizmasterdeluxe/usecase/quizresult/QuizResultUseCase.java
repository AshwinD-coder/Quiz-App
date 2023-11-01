package com.quizmasterdeluxe.usecase.quizresult;


import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterUseCase;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class QuizResultUseCase {

    private final QuizFilterUseCase quizFilterUseCase;


    @Inject
    public QuizResultUseCase(QuizFilterUseCase quizFilterUseCase) {
        this.quizFilterUseCase = quizFilterUseCase;
    }

    public QuizResultResponse execute(Map<String, String> quizResultRequest) {

        System.out.println(quizResultRequest);

        // user provided answer   => quizResultRequest
        // correct answer ...

        System.out.println(TemporaryHolder.get().name());

        Map<String, String> systemQuizResult = new HashMap<>();

        for (QuizFilterResult result : TemporaryHolder.get().resultHolder()) {
            systemQuizResult.put(result.getQuestion(), result.getCorrectAnswer());
        }


        // correct answer check  => user provided answer


        int score = 0;
        Map<String, String> playerCorrectAnswer = new HashMap<>();
        Map<String, String> playerWrongAnswer = new HashMap<>();

        for (Map.Entry<String, String> entry : systemQuizResult.entrySet()) {
            String question = entry.getKey();

            String correctAnswer = entry.getValue();

            String userAnswer = quizResultRequest.get(question);

            if(correctAnswer.equals(userAnswer))
            {
                score++;
                playerCorrectAnswer.put(question,correctAnswer);

            }
            else {
                playerWrongAnswer.put(question,userAnswer);
            }

        }

return new QuizResultResponse(TemporaryHolder.get().name(),score,playerCorrectAnswer,playerWrongAnswer);
    }


}
