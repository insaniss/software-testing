package ru.ifmo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipTest {
    private SpaceShip ship;
    private List<Human> humans;

    @BeforeEach
    void setUp() {
        this.ship = new SpaceShip();
        this.humans = List.of(
            new Human("John", Gender.MALE),
            new Human("Bob", Gender.MALE),
            new Human("Anna", Gender.FEMALE),
            new Human("Robert", Gender.MALE)
        );
    }

    @Test
    void testGetInAndGetOutMethodsWithoutThrowingAnyExceptions() {
        assertAll(
          () -> assertDoesNotThrow(() -> {
              for (var human : humans) ship.getIn(human);
          }),
          () -> assertDoesNotThrow(() -> {
              for (var human : humans) ship.getOut(human);
          })
        );
    }

    @Test
    void testGetInAndGetOutMethodsWithThrowingExceptions() {
        var exception = IllegalStateException.class;
        ship.getIn(humans.get(0));
        ship.fly();
        assertAll(
          () -> assertThrows(exception, () -> ship.getIn(null)),
          () -> assertThrows(exception, () -> ship.getOut(null))
        );
    }

    @Test
    void testFlyAndLandMethodsWithoutThrowingAnyExceptionsAndWith() {
        var exception = IllegalStateException.class;
        ship.getIn(humans.get(0));
        assertAll(
          () -> assertDoesNotThrow(() -> ship.fly()),
          () -> assertThrows(exception, () -> ship.fly()),
          () -> assertDoesNotThrow(() -> ship.land()),
          () -> assertThrows(exception, () -> ship.land())
        );
    }

    @Test
    void testFlyMethodWithEmptyCrewAndDestroyedEngine() {
        var exception = IllegalStateException.class;
        assertAll(
          () -> assertThrows(exception, () -> ship.fly()),
          () -> assertThrows(exception, () -> {
              ship.getIn(humans.get(0));
              ship.getEngine().destroy();
              ship.fly();
          })
        );
    }
}
