package com.quizmasterdeluxe.platform.quizholder;


public class TemporaryHolder {

    private static ThreadLocal<QuizResultHolder> context = new ThreadLocal<>();

    public static QuizResultHolder get() {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        return context.get();
    }


    public static void set(QuizResultHolder quizResultHolder) {
        if (context == null) {
            context = new ThreadLocal<>();
        }
        context.set(quizResultHolder);
    }


}
