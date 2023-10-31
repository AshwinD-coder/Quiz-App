package com.quizmasterdeluxe.resource;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("/")
public class LandingPageController {
    @View("index")
    @Get("/")
    public HttpResponse<?> index()  {
        return HttpResponse.ok();
    }
}
