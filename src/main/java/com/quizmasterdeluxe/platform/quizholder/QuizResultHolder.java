package com.quizmasterdeluxe.platform.quizholder;

import com.quizmasterdeluxe.usecase.quizfilter.QuizFilterResult;

import java.util.List;


public record QuizResultHolder(List<QuizFilterResult> resultHolder, String name) {
}
