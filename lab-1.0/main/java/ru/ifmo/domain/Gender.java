package ru.ifmo.domain;

public enum Gender {
    MALE("мужской"),
    FEMALE("женский");

    private final String message;

    Gender(String message) {
        this.message = message;
    }
}
