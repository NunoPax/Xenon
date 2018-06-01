package org.academiadecodigo.xenon.world.gameobjects.ships;

import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.gameobjects.Projectile;
import org.academiadecodigo.xenon.world.factories.ProjectileFactory;
import org.academiadecodigo.xenon.world.interfaces.Controllable;

public class PlayerShip extends SpaceShip implements Controllable {
    private int score = 0;
    private ProjectileFactory factory;
    private World world;
    private boolean shooting = false;

    public PlayerShip(int x, int y, CollisionDetector collisionDetector, Game game, ProjectileFactory factory, World world) {
        super(x, y, 57, 61, collisionDetector, game, "res/playerShip.png");
        this.setHeading(Direction.RIGHT);
        this.show();
        this.factory = factory;
        this.world = world;
    }

    @Override
    public void tick() {
        if (shooting) {
            this.shoot();
        }

        super.tick();
    }

    @Override
    public void setShooting(boolean shooting) {
        this.shooting = shooting;
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

        p.moveRelativeTo(this, 60, 18);
        p.show();
        p.setDirection(Direction.RIGHT);
        world.add(p);
        p.setCreator(this);

        this.shooting = false;
    }
}
