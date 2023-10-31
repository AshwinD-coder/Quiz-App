package com.quizmasterdeluxe.platforms.usecase;

import java.util.Optional;

@FunctionalInterface
public interface UseCase<I extends UseCaseRequest, O extends  UseCaseResponse> {
    Optional<O> execute(I request);
}
