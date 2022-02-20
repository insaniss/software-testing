package ru.ifmo.domain;

import static ru.ifmo.domain.HumanState.*;

public class Human {
    private String name;
    private HumanState state;

    public Human(String name) {
        this.name = name;
        this.state = NORMAL;
    }

    public void setState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void feelComfort() {
        this.state = COMFORTABLE;
    }

    public void feelDiscomfort() {
        this.state = UNCOMFORTABLE;
    }

    public void feelNothing() {
        this.state = NORMAL;
    }

    public HumanState getState() {
        return state;
    }
}
