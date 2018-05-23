package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable {

    private CollisionDetector collisionDetector;

    public SpaceShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap) {
        super(x, y, gameMap);
    }

    public void shoot() {
    }

    public void hit() {
    }
}
