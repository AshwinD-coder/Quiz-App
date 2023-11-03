package com.quizmasterdeluxe.usecase.quizfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizmasterdeluxe.platform.usecase.UseCase;
import com.quizmasterdeluxe.platform.quizholder.QuizResultHolder;
import com.quizmasterdeluxe.platform.quizholder.TemporaryHolder;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Singleton
public class QuizFilterUseCase implements UseCase<QuizFilterRequest, QuizFilterResponse> {
    public Optional<QuizFilterResponse> execute(QuizFilterRequest quizFilterRequest) {
        String openTriviaUrl = "https://opentdb.com/api.php?amount=10&category=" + quizFilterRequest.getCategory() + "&difficulty=" + quizFilterRequest.getDifficulty() + "&type=multiple";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(openTriviaUrl))
                    .build();
            HttpResponse httpResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String openTriviaResponse = httpResponse.body().toString();
            QuizFilterResponse response = new ObjectMapper().readValue(openTriviaResponse, QuizFilterResponse.class);
            response.setName(quizFilterRequest.getName());
            collectCorrectQuestionAnswer(response);
            return Optional.of(response);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void collectCorrectQuestionAnswer(QuizFilterResponse response) {
        List<QuizFilterResult> resultsList = response.getResultsList();
        String name = response.getName();
        TemporaryHolder.set(new QuizResultHolder(resultsList, name));


    }
}
