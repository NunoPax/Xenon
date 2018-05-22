package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;

public class PlayerShip extends SpaceShip {

    public PlayerShip(int x, int y, CollisionDetector collisionDetector) {
        super(x, y, collisionDetector);
    }
}
