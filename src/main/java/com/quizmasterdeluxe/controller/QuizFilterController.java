package com.quizmasterdeluxe.controller;

import com.quizmasterdeluxe.usecase.quizfilter.QuizFilter;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;
import jakarta.inject.Inject;

@Controller("/quiz")
public class QuizFilterController {
    private final QuizFilter quizFilter;
    @Inject
    public QuizFilterController(QuizFilter quizFilter) {
        this.quizFilter = quizFilter;
    }

    @View("quiz-filter")
    @Get("/")
    public HttpResponse<?> quizFilter(){
        return HttpResponse.ok();
    }



}
