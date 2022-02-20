package ru.ifmo.domain;

public class Engine {
    private final EngineType type;
    private EngineState state;

    public Engine(EngineType type) {
        this.type = type;
        this.state = EngineState.NOT_DESTROYED;
    }

    public void destroy() {
        this.state = EngineState.DESTROYED;
    }

    public void fix() {
        this.state = EngineState.NOT_DESTROYED;
    }

    public EngineType getType() {
        return type;
    }

    public EngineState getState() {
        return state;
    }
}
