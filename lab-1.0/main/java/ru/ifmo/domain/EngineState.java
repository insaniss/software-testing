package ru.ifmo.domain;

public enum EngineState {
    DESTROYED("сломанный"),
    NOT_DESTROYED("не сломанный");

    private final String message;

    EngineState(String message) {
        this.message = message;
    }
}
