package com.quizmasterdeluxe.usecase.quizfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Singleton
public class QuizFilterUseCase  {
    public QuizFilterResponse execute(QuizFilterRequest quizFilterRequest) {
        String openTriviaUrl = "https://opentdb.com/api.php?amount=10&category=" + quizFilterRequest.getCategory() + "&difficulty=" + quizFilterRequest.getDifficulty() + "&type=multiple";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(openTriviaUrl))
                    .build();
            HttpResponse httpResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String openTriviaResponse = httpResponse.body().toString();
            QuizFilterResponse response = new ObjectMapper().readValue(openTriviaResponse, QuizFilterResponse.class);
            response.setName(quizFilterRequest.getName());
            return response;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
