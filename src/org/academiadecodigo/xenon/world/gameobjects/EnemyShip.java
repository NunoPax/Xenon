package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Gun;

public class EnemyShip extends SpaceShip implements Scorable {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private int score = 5;
    private World world;
    private EnemyShipFactory enemyShipFactory;
    private Gun gun;

    private long timestamp = System.currentTimeMillis();
    private long cooldown = 1500;

    public EnemyShip(int x, int y, CollisionDetector collisionDetector, Game game, World world, EnemyShipFactory enemyShipFactory) {
        super(x, y, WIDTH, HEIGHT, collisionDetector, game, "res/enemyShip.png");
        this.setHeading(Direction.LEFT);
        this.world = world;
        this.enemyShipFactory = enemyShipFactory;
        this.gun = new Gun(this, world, 1, "res/enemyProjectile.png");
        this.gun.setProjectileSpawn(-40, 18);
        this.setDirection(this.getHeading());
    }

    @Override
    public void tick() {
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
        this.enemyShipFactory.offer(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
        this.enemyShipFactory.offer(this);
    }

    @Override
    public void shoot() {
        long now = System.currentTimeMillis();

        if (now < timestamp + cooldown) {
            return;
        }

        this.timestamp = now;
        this.gun.shoot();
        (new Sound("/sound/Laser_Shoot42.wav")).getClip().loop(0);
    }
}
