package ru.ifmo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrewTest {
    private Crew crew;

    @BeforeEach
    void setUp() {
        this.crew = new Crew();
    }

    @Test
    void testAddAndRemoveMethodsWithThrowingIllegalArgumentException() {
        var exception = IllegalArgumentException.class;
        var human = new Human(null, null);
        assertAll(
          () -> assertDoesNotThrow(() -> crew.addMember(human)),
          () -> assertThrows(exception, () -> crew.addMember(human)),
          () -> assertDoesNotThrow(() -> crew.removeMember(human)),
          () -> assertThrows(exception, () -> crew.removeMember(human))
        );
    }
}
