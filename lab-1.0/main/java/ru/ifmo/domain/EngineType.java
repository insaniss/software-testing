package ru.ifmo.domain;

public enum EngineType {
    THERMAL("тепловой"),
    ELECTRICAL("электрический"),
    PHYSICAL("физический");

    private final String message;

    EngineType(String message) {
        this.message = message;
    }
}
