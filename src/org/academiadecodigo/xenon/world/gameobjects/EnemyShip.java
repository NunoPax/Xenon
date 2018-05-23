package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;

public class EnemyShip extends SpaceShip {

    public EnemyShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap) {
        super(x, y, collisionDetector, gameMap);
    }
}
