package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.CollisionDetector;

public abstract class SpaceShip extends GameObject implements Shootable {

    private CollisionDetector collisionDetector;

    public SpaceShip(int x, int y, CollisionDetector collisionDetector) {
        super(x, y);
    }

    public void shoot() {
    }
}
