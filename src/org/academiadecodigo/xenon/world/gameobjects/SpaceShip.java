package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable {

    private CollisionDetector collisionDetector;
    private ProjectileFactory projectileFactory;
    private Game game;
    private boolean shooting;

    public SpaceShip(int x, int y, int width, int height, CollisionDetector collisionDetector, GameMap gameMap, Game game, String pathname) {
        super(x, y, width, height, gameMap, pathname);
        this.collisionDetector = collisionDetector;
        this.game = game;
        this.projectileFactory = game.getProjectileFactory();
    }


    @Override
    public void tick() {
        if (shooting) {
            this.doShoot();
        }

        super.tick();
    }

    public void doShoot() {
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

        this.shooting = false;
    }

    public void hit() {
        this.destroy();
    }

    public void shoot() {
        this.shooting = true;
    }
}
