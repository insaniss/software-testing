package ru.ifmo.domain;

public class SpaceShip {
    private final Crew crew;
    private Engine engine;

    private SpaceShipState state;

    /**
     * Constructs a spaceship with empty crew and thermal engine.
     */
    public SpaceShip() {
        this.engine = new Engine(EngineType.THERMAL);
        this.crew = new Crew();
        this.state = SpaceShipState.STANDING;
    }

    public Engine getEngine() {
        return engine;
    }

    public SpaceShipState getState() {
        return state;
    }

    /**
     * Gets in a human into the crew.
     *
     * @param human {@code Human} representing a human entity.
     * @throws IllegalStateException if the ship isn't on the ground.
     */
    public void getIn(Human human) {
        if (state != SpaceShipState.STANDING) {
            throw new IllegalStateException("Could not get in, cause ship isn't on the ground");
        } else {
            this.crew.addMember(human);
        }
    }

    /**
     * Gets out a human from the crew.
     *
     * @param human {@code Human} representing a human entity.
     * @throws IllegalStateException if the ship isn't on the ground.
     */
    public void getOut(Human human) {
        if (state != SpaceShipState.STANDING) {
            throw new IllegalStateException("Could not get out, cause ship isn't on the ground");
        } else {
            this.crew.removeMember(human);
        }
    }

    /**
     * Sets a new engine to the {@code Spaceship}.
     *
     * @param engine {@code Engine} representing a spaceship engine.
     * @throws IllegalStateException if the ship isn't on the ground.
     */
    public void setEngine(Engine engine) {
        if (state != SpaceShipState.STANDING) {
            throw new IllegalStateException("Could not set engine, cause ship isn't on the ground");
        } else {
            this.engine = engine;
        }
    }

    /**
     * Sets the spaceship state as {@code FLYING}.
     *
     * @throws IllegalStateException cases: <ul><li>if the ship is already flying.
     *         <li>if a crew is empty.<li>if the ship engine is destroyed.</ul>
     */
    public void fly() {
        if (state == SpaceShipState.FLYING) {
            throw new IllegalStateException("Spaceship is already flying");
        } else if (crew.isEmpty()) {
            throw new IllegalStateException("Spaceship cannot fly without a crew");
        } else if (engine.isDestroyed()) {
            throw new IllegalStateException("Spaceship cannot with a destroyed engine");
        } else {
            this.state = SpaceShipState.FLYING;
        }
    }

    /**
     * Sets the spaceship state as {@code LANDING}.
     *
     * @throws IllegalStateException if the ship is already on the ground.
     */
    public void land() {
        if (state == SpaceShipState.STANDING) {
            throw new IllegalStateException("Spaceship is already on the ground");
        } else {
            this.state = SpaceShipState.STANDING;
        }
    }
}
