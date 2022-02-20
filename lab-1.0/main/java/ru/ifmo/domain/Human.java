package ru.ifmo.domain;

public class Human {
    private String name;
    private HumanState state;

    public Human(String name) {
        this.name = name;
        this.state = HumanState.NORMAL;
    }

    public void setState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void feelComfort() {
        this.state = HumanState.COMFORTABLE;
    }

    public void feelDiscomfort() {
        this.state = HumanState.UNCOMFORTABLE;
    }

    public void feelNothing() {
        this.state = HumanState.NORMAL;
    }

    public HumanState getState() {
        return state;
    }
}
