package com.quizmasterdeluxe.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/quiz")
public class QuizFilterController {

    @View("quiz-filter")
    @Get("/")
    public HttpResponse<?> quizFilter(){
        return HttpResponse.ok();
    }

}
