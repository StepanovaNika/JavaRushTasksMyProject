package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> glass;

    public Generator(Class<T> glass) {
        this.glass = glass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T)glass.newInstance();
    }
}
