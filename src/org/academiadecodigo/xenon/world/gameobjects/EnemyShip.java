package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;

public class EnemyShip extends SpaceShip {

    public EnemyShip(int x, int y, CollisionDetector collisionDetector) {
        super(x, y, collisionDetector);
    }
}
