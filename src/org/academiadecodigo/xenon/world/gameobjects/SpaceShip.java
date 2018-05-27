package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable {

    private CollisionDetector collisionDetector;

    public SpaceShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap) {
        super(x, y, gameMap);
        this.collisionDetector = collisionDetector;
    }

    public void shoot() {
        Projectile p = new Projectile(this.getX(), this.getY(), this.getGameMap());
        p.setHeading(this.getHeading());
        this.collisionDetector.add(p);
    }

    public void hit() {
    }
}
