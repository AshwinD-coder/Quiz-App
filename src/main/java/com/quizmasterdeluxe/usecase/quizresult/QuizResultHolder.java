package com.quizmasterdeluxe.usecase.quizresult;

import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;

import java.util.List;


public record QuizResultHolder(List<QuizFilterResult> resultHolder, String name) {
}
