package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Gun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileType;

public class EnemyShip extends SpaceShip implements Scorable {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private int score = 5;
    private World world;
    private Shootable gun;
    private EnemyShipFactory factory;

    private long timestamp = System.currentTimeMillis();
    private long cooldown = 1500;

    public EnemyShip(int x, int y, World world, SpaceShipType type, EnemyShipFactory factory) {
        super(x, y, type, world);
        this.world = world;
        this.factory = factory;
        this.gun = new Gun(this, this.world, 1, ProjectileType.CIRCLE);
        this.gun.setProjectileSpawn(-40, 18);
        this.setHeading(Direction.LEFT);
        this.setDirection(this.getHeading());
    }

    @Override
    public void tick() {
        if (this.isDestroyed() || this.isDisposed()) {
            return;
        }

        super.tick();
        this.shoot();

        for (GameObject other : this.world.overlaping(this)) {
            if (other instanceof PlayerShip) {
                ((PlayerShip) other).hit();
                this.hit();
            }
        }
    }

    @Override
    public int score(){
       return score;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.world.remove(this);
        this.factory.offer(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
        this.factory.offer(this);
    }

    @Override
    public void shoot() {
        long now = System.currentTimeMillis();

        if (now < timestamp + cooldown) {
            return;
        }

        this.timestamp = now;
        this.gun.shoot();
    }

    @Override
    public void setProjectileSpawn(int dx, int dy) {
        this.gun.setProjectileSpawn(dx, dy);
    }
}
