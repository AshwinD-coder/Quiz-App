package com.quizmasterdeluxe.usecase.quizfilter;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class QuizFilterUseCaseTest {
    @Inject
    private QuizFilterUseCase quizFilterUseCase;

    @Test
    void shouldReturnUserNameWithCorrectUserName() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "easy", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        QuizFilterResponse quizFilterResponse = response.get();
        assertEquals("dipendra", quizFilterResponse.getName());
    }

    @Test
    void shouldGetQuestionAndAnswers() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "easy", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals(0, response.get().getResponseCode());
    }

    @Test
    void shouldGetQuestionWithCorrectDifficultyLevelEasy() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "easy", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("easy", response.get().getResultsList().get(0).getDifficulty());
    }

    @Test
    void shouldGetQuestionWithCorrectDifficultyLevelMedium() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "medium", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("medium", response.get().getResultsList().get(0).getDifficulty());
    }

    @Test
    void shouldGetQuestionWithCorrectDifficultyLevelHard() {
        QuizFilterRequest request = new QuizFilterRequest("dipendra", "hard", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("hard", response.get().getResultsList().get(0).getDifficulty());
    }

    @Test
    void shouldGetQuestionWithCorrectCategoryGeneralKnowledge() {
        QuizFilterRequest request = new QuizFilterRequest("Sandesh", "hard", "9");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("General Knowledge", response.get().getResultsList().get(0).getCategory());
    }

    @Test
    void shouldGetQuestionWithCorrectCategoryComputerScience() {
        QuizFilterRequest request = new QuizFilterRequest("Sandesh", "hard", "18");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("Science: Computers", response.get().getResultsList().get(0).getCategory());
    }

    @Test
    void shouldGetQuestionWithCorrectCategoryEntertainmentJapaneseAnimeAndManga() {
        QuizFilterRequest request = new QuizFilterRequest("Sandesh", "hard", "31");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("Entertainment: Japanese Anime & Manga", response.get().getResultsList().get(0).getCategory());
    }

    @Test
    void shouldGetQuestionWithCorrectCategoryGeography() {
        QuizFilterRequest request = new QuizFilterRequest("Sandesh", "hard", "22");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("Geography", response.get().getResultsList().get(0).getCategory());
    }

    @Test
    void shouldGetQuestionWithCorrectCategorySports() {
        QuizFilterRequest request = new QuizFilterRequest("Sandesh", "hard", "21");
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(request);
        assertTrue(response.isPresent());
        Assertions.assertEquals("Sports", response.get().getResultsList().get(0).getCategory());
    }


}