package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;

public interface Movable {
    void tick();
    void setDirection(Direction direction);
    /**
     *
     * return Direction.UP or Direction.DOWN
     */
    Direction getHeading();
}
