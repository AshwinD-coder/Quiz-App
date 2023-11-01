package com.quizmasterdeluxe.resources;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.ModelAndView;
import io.micronaut.views.View;

@Controller("/")
public class LandingPageResource {
    @View()
    @Get()
    public ModelAndView landingPage()  {
        return new ModelAndView("landing-page",null);
    }
}
