package com.quizmasterdeluxe.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;

@Controller("quiz-start")
public class QuizStartController {
    @View()
    @Get()
    public ModelAndView quizPage(){
        return new ModelAndView("quiz-start.hbs",null);
    }
}
