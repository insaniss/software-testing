package ru.ifmo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private List<Human> humans;

    @BeforeEach
    void setUp() {
        this.humans = List.of(
            new Human("John", Gender.MALE),
            new Human("Bob", Gender.MALE),
            new Human("Anna", Gender.FEMALE),
            new Human("Robert", Gender.MALE)
        );
    }

    @ParameterizedTest(name = "state = {0}")
    @EnumSource(HumanState.class)
    void testHumanFeelMethods(HumanState state) {
        for (var human : humans) {
            switch (state) {
                case UNCOMFORTABLE -> human.feelDiscomfort();
                case COMFORTABLE -> human.feelComfort();
                case NORMAL -> human.feelNothing();
            }
            assertEquals(state, human.getState());
        }
    }
}
