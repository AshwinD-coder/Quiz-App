package com.quizmasterdeluxe.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;

@Controller("/")
public class LandingPageController {
    @View()
    @Get()
    public ModelAndView index()  {
        return  new ModelAndView("landing-page",null);
    }
}
