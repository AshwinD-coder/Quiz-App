package com.quizmasterdeluxe.usecase.quizresult;

import com.quizmasterdeluxe.platform.quizholder.QuizResultHolder;
import com.quizmasterdeluxe.platform.quizholder.TemporaryHolder;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizResultUseCaseTest {
    @Inject
    private TemporaryHolder temporaryHolder;
    @Inject
    private QuizResultUseCase quizResultUseCase;

    @BeforeEach
    public void setUp() {
        temporaryHolder = new TemporaryHolder();
        quizResultUseCase = new QuizResultUseCase();
    }

    @Test
    public void shouldExecuteAllCorrectAnswers() {
        temporaryHolder.set(createMockQuizResultHolder());
        QuizResultRequest quizResultRequest = createMockQuizResultRequestWithAllCorrectAnswers();
        Optional<QuizResultResponse> result = quizResultUseCase.execute(quizResultRequest);
        assertEquals(1, result.get().getScore());
    }

    private QuizResultRequest createMockQuizResultRequestWithAllCorrectAnswers() {
        Map<String, String> questionAnswer = new HashMap<>();
        questionAnswer.put("Which company was established on April 1st, 1976 by Steve Jobs, Steve Wozniak and Ronald Wayne?", "Apple");
        return new QuizResultRequest(questionAnswer);
    }

    private QuizResultHolder createMockQuizResultHolder() {
        List<QuizFilterResult> quizFilterResults = new ArrayList<>();
        String category = "Science: Computers";
        String type = "Multiple choice";
        String difficulty = "easy";
        String question = "Which company was established on April 1st, 1976 by Steve Jobs, Steve Wozniak and Ronald Wayne?";
        String correctAnswer = "Apple";
        String[] incorrectAnswers = {"Atari", "Microsoft", "Commodore"};
        QuizFilterResult quizFilterResult = new QuizFilterResult();
        quizFilterResult.setCategory(category);
        quizFilterResult.setType(type);
        quizFilterResult.setDifficulty(difficulty);
        quizFilterResult.setQuestion(question);
        quizFilterResult.setCorrectAnswer(correctAnswer);
        quizFilterResult.setIncorrectAnswers(incorrectAnswers);
        quizFilterResults.add(quizFilterResult);
        return new QuizResultHolder(quizFilterResults, "Ashwin Dhougoda");
    }

    @Test
    public void shouldExecuteMixedAnswersWithIncorrectAnswers() {
        temporaryHolder.set(createMockQuizResultHolder());
        QuizResultRequest quizResultRequest = createMockQuizResultRequestWithMixedAnswersAndIncorrectAnswers();
        Optional<QuizResultResponse> result = quizResultUseCase.execute(quizResultRequest);
        assertEquals(0, result.get().getScore());
    }

    private QuizResultRequest createMockQuizResultRequestWithMixedAnswersAndIncorrectAnswers() {
        Map<String, String> questionAnswer = new HashMap<>();
        questionAnswer.put("Which company was established on April 1st, 1976 by Steve Jobs, Steve Wozniak and Ronald Wayne?", "Atari"); // Incorrect answer
        return new QuizResultRequest(questionAnswer);
    }


}