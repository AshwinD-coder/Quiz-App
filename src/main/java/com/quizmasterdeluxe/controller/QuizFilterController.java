package com.quizmasterdeluxe.controller;

import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterRequest;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResponse;
import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterUseCase;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/quiz-filter")
public class QuizFilterController {
    private final QuizFilterUseCase quizFilterUseCase;

    @Inject
    public QuizFilterController(QuizFilterUseCase quizFilterUseCase) {
        this.quizFilterUseCase = quizFilterUseCase;
    }

    @View()
    @Get()
    public ModelAndView quizFilter() {
        return new ModelAndView("quiz-filter", null);
    }

    @Post("/start")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ModelAndView<QuizFilterResponse> getQuestionsAndRenderTemplate(@Body QuizFilterRequest quizFilterRequest) {
        Optional<QuizFilterResponse> response = quizFilterUseCase.execute(quizFilterRequest);
        return new ModelAndView<>("quiz-start", response.get());
    }


}
