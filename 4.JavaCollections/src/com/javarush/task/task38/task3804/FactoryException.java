package com.javarush.task.task38.task3804;

public class FactoryException {
    public static Throwable getException(Enum type) throws Exception {

        if (type != null) {
            String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");
            if (type instanceof ExceptionApplicationMessage) {
                return new Exception(message);
            } else if (type instanceof ExceptionDBMessage) {
                return new RuntimeException(message);
            } else if (type instanceof ExceptionUserMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
