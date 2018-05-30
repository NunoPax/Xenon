package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.Game;

public class PlayerShip extends SpaceShip implements Controllable {
    private int score = 0;
    private ProjectileFactory factory;
    boolean shooting = false;
    private World world;

    public PlayerShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game, ProjectileFactory factory, World world) {
        super(x, y, 57, 61, collisionDetector, gameMap, game, "res/playerShip.png");
        this.setHeading(Direction.RIGHT);
        this.show();
        this.factory = factory;
        this.world = world;
    }

    @Override
    public void setShooting(boolean shooting) {
        this.shoot();
    }

    public void doShoot() {
        Projectile p = this.factory.get(this.getX(), this.getY());
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
        world.add(p);
        p.setCreator(this);

        this.shooting = false;
    }

    @Override
    public boolean isControllable() {
        return !this.isDestroyed();
    }

    @Override
    public void addPoints(int points) {
        this.score += points;
    }

    @Override
    public int score() {
        return this.score;
    }

    @Override
    public void shoot() {
        Projectile p = this.factory.get(this.getX(), this.getY());

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
        p.setCreator(this);

        this.shooting = false;
    }
}
