package com.quizmasterdeluxe.usecase.quizresult;

import com.quizmasterdeluxe.platform.quizholder.QuizResultHolder;
import com.quizmasterdeluxe.platform.quizholder.TemporaryHolder;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizResultUseCaseTest {
    private TemporaryHolder temporaryHolder;
    private QuizResultUseCase quizResultUseCase;

    @BeforeEach
    public void setUp() {
        temporaryHolder = new TemporaryHolder();
        quizResultUseCase = new QuizResultUseCase(new QuizFilterUseCase());
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
        questionAnswer.put("What amount of bits commonly equals one byte?", "8");
        questionAnswer.put("In computing, what does LAN stand for?", "Local Area Network");
        questionAnswer.put("What does the computer software acronym JVM stand for?", "Java Virtual Machine");
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
        assertEquals(1, result.get().getScore());
    }

    private QuizResultRequest createMockQuizResultRequestWithMixedAnswersAndIncorrectAnswers() {
        Map<String, String> questionAnswer = new HashMap<>();
        questionAnswer.put("Which company was established on April 1st, 1976 by Steve Jobs, Steve Wozniak and Ronald Wayne?", "Apple"); // Incorrect answer
        questionAnswer.put("The programming language 'Swift' was created to replace what other programming language?", "Objective-C");
        questionAnswer.put("Which programming language shares its name with an island in Indonesia?", "C");
        questionAnswer.put("How long is an IPv6 address?", "128 bits");
        questionAnswer.put("What does the computer software acronym JVM stand for?", "Java Virtual Machine");
        return new QuizResultRequest(questionAnswer);
    }




}