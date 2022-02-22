package ru.ifmo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    private Engine engine;

    @BeforeEach
    void setUp() {
        this.engine = new Engine(EngineType.THERMAL);
    }

    @Test
    void testStateOfEngineAfterDestroyingAndFixing() {
        assertAll(
          () -> assertDoesNotThrow(() -> engine.destroy()),
          () -> assertEquals(EngineState.DESTROYED, engine.getState()),
          () -> assertDoesNotThrow(() -> engine.fix()),
          () -> assertEquals(EngineState.NOT_DESTROYED, engine.getState())
        );
    }

    @Test
    void testInitialStateOfThermalEngine() {
        assertFalse(engine.isDestroyed());
    }

    @ParameterizedTest(name = "type = {0}")
    @EnumSource(EngineType.class)
    void testEngineConstruct(EngineType type) {
        assertEquals(type, new Engine(type).getType());
    }
}
