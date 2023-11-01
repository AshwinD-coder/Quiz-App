package com.quizmasterdeluxe.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/")
public class LandingPageController {
    @View("landing-page")
    @Get("/")
    public HttpResponse<?> index()  {
        return  HttpResponse.ok();
    }
}
