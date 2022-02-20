package ru.ifmo.domain;

public enum HumanState {
    COMFORTABLE("уютный"),
    UNCOMFORTABLE("неуютный"),
    NORMAL("нормальный");

    private final String message;

    HumanState(String message) {
        this.message = message;
    }
}
