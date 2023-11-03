package com.quizmasterdeluxe.controller;


import com.quizmasterdeluxe.converter.MapToQuizResultRequest;
import com.quizmasterdeluxe.platform.exception.QuizMasterException;
import com.quizmasterdeluxe.platform.exception.QuizMasterExceptionType;
import com.quizmasterdeluxe.usecase.quizresult.QuizResultRequest;
import com.quizmasterdeluxe.usecase.quizresult.QuizResultResponse;
import com.quizmasterdeluxe.usecase.quizresult.QuizResultUseCase;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.ModelAndView;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.Map;

@Controller("/quiz-result")
public class QuizResultController {


    private final QuizResultUseCase quizResultUseCase;

    @Inject
    public QuizResultController(QuizResultUseCase quizResultUseCase) {
        this.quizResultUseCase = quizResultUseCase;
    }

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ModelAndView<QuizResultResponse> quizResult(@Body @Nullable Map<String, String> userQuestionsAnswers) {
        if (userQuestionsAnswers == null) {
            throw new QuizMasterException(QuizMasterExceptionType.ATLEAST_ONE_ANSWER);
        }
        QuizResultRequest quizResultRequest = MapToQuizResultRequest.toQuizResultRequest(userQuestionsAnswers);
        QuizResultResponse response = quizResultUseCase.execute(quizResultRequest).get();
        return new ModelAndView<>("quiz-result", response);
    }

    @Get("/error/")
    public ModelAndView error(@QueryValue("errorCode") String errorCode, @QueryValue("errorMessage") String errorMessage) {
        Map<String, Object> errorModel = new HashMap<>();
        errorModel.put("errorCode", errorCode);
        errorModel.put("errorMessage", errorMessage);
        return new ModelAndView("error", errorModel);
    }
}
