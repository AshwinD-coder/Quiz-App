package com.quizmasterdeluxe.platform.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Produces
@Singleton
@Requires(classes = {QuizMasterException.class, ExceptionHandler.class})
public class QuizMasterExceptionHandler implements ExceptionHandler<QuizMasterException, HttpResponse<Object>> {
    @Override
    public HttpResponse<Object> handle(HttpRequest request, QuizMasterException exception) {
        String errorCode = URLEncoder.encode(exception.getType().getCode(), StandardCharsets.UTF_8);
        String errorMessage = URLEncoder.encode(exception.getType().getMessage(), StandardCharsets.UTF_8);
        URI errorPageUri = URI.create("/quiz-result/error?errorCode=" + errorCode + "&errorMessage=" + errorMessage);
        return HttpResponse.redirect(errorPageUri);
    }
}
