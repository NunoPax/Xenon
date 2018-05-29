package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable {

    private CollisionDetector collisionDetector;
    private ProjectileFactory projectileFactory;
    private Game game;

    public SpaceShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, gameMap);
        this.collisionDetector = collisionDetector;
        this.game = game;
        this.projectileFactory = game.getProjectileFactory();
    }

    public void shoot() {
        Projectile p = this.projectileFactory.get(this.getX(), this.getY());

        if (p == null) {
            return;
        }

        p.show();
        p.setHeading(this.getHeading());
        p.setDirection(this.getHeading());
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        p.move();
        game.register(p);
        this.collisionDetector.add(p);
    }

    public void hit() {
        this.destroy();
    }


}
