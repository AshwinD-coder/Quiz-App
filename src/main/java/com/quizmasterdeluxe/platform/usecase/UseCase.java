package com.quizmasterdeluxe.platform.usecase;

import java.util.Optional;

@FunctionalInterface
public interface UseCase<I extends UseCaseRequest, O extends UseCaseResponse> {
    Optional<O> execute(I request);
}
