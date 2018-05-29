package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable {

    private CollisionDetector collisionDetector;
    private Game game;


    public SpaceShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, gameMap);
        this.collisionDetector = collisionDetector;
        this.game = game;
    }

    public void shoot() {
        Projectile p = new Projectile(this.getX(), this.getY(), this.getGameMap());
        p.show();
        p.setHeading(this.getHeading());
        p.setDirection(this.getHeading());
        game.register(p);
        //this.collisionDetector.add(p);
    }

    public void hit() {
    }

}
