package ru.ifmo.domain;

public enum SpaceShipState {
    FLYING("летающий"),
    STANDING("стоящий"),
    FALLING("падающий");

    private final String message;

    SpaceShipState(String message) {
        this.message = message;
    }
}
