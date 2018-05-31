package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Gun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Projectile;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

public class PlayerShip extends SpaceShip implements Controllable {
    private int score = 0;
    private ProjectileFactory factory;
    private World world;
    private boolean shooting = false;
    private Gun gun;

    public PlayerShip(int x, int y, CollisionDetector collisionDetector, Game game, ProjectileFactory factory, World world) {
        super(x, y, 57, 61, collisionDetector, game, "res/playerShip.png");
        this.setHeading(Direction.RIGHT);
        this.show();
        this.factory = factory;
        this.world = world;
        this.gun = new Gun(this, this.world, 5);
        this.gun.setProjectileSpawn(60, 18);
    }

    @Override
    public void tick() {
        super.tick();
        this.shoot();
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
        if (shooting) {
            this.gun.shoot();
            this.shooting = false;
            (new Sound("/sound/Laser_Shoot53.wav")).getClip().loop(0);
        }
    }
}
