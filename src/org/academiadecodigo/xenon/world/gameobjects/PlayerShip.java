package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.BasicGun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileType;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.TriGun;

public class PlayerShip extends SpaceShip implements Controllable {
    private int score = 0;
    private World world;
    private volatile boolean shooting = false;
    private Shootable gun;

    public PlayerShip(int x, int y, World world) {
        super(x, y, SpaceShipType.PLAYER, world);
        this.setHeading(Direction.EAST);
        this.world = world;
        this.gun = new BasicGun(this, this.world, 5, ProjectileType.STAR);
        //this.gun = new TriGun(this, this.world, 5, ProjectileType.STAR);
        this.gun.setProjectileSpawn(60, 18, Direction.EAST);
        //this.show();
        this.speed = 4;
    }

    @Override
    public void tick() {
        // For trial mode
        if (this.score >= 50 && this.gun instanceof BasicGun) {
            this.gun = new TriGun(this, this.world, 5, ProjectileType.STAR);
            this.gun.setProjectileSpawn(60, 18);
        }

        super.tick();

        if (super.isOutOfBounds()) {
            this.dispose();
        }

        super.clamp();

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

    @Override
    public void setProjectileSpawn(int dx, int dy) {
        this.gun.setProjectileSpawn(dx, dy);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy, Direction direction) {
        throw new UnsupportedOperationException();
    }
}
