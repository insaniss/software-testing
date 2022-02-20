package ru.ifmo.domain;

public class Human {
    private final String name;
    private final Gender gender;

    private HumanState state = HumanState.NORMAL;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
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
