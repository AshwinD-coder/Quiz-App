package com.quizmasterdeluxe.platform.exception;

import com.quizmasterdeluxe.platform.restresponse.RestResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {QuizMasterException.class, ExceptionHandler.class})
public class QuizMasterExceptionHandler implements ExceptionHandler<QuizMasterException, HttpResponse<Object>> {
    @Override
    public HttpResponse<Object> handle(HttpRequest request, QuizMasterException exception) {
        return HttpResponse.badRequest().body(RestResponse.error(exception.getType().getCode(),exception.getMessage()));
    }
}
