package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.BasicGun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileType;

import org.academiadecodigo.xenon.sound.*;

public class EnemyShip extends SpaceShip implements Scorable {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private int score = 5;
    private World world;
    private Shootable gun;
    private EnemyShipFactory factory;

    private long timestamp = System.currentTimeMillis();
    private long cooldown = 1500;

    private SpaceShipType type;

    private Sound sound = new Sound(GameSound.ENEMY_LASER);

    public EnemyShip(int x, int y, World world, SpaceShipType type, EnemyShipFactory factory) {
        super(x, y, type, world);
        this.world = world;
        this.factory = factory;
        this.gun = new BasicGun(this, this.world, 1, ProjectileType.CIRCLE);
        this.gun.setProjectileSpawn(-40, 18, Direction.WEST);
        this.setHeading(Direction.WEST);
        this.setDirection(this.getHeading());
        this.type = type;
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
        //(new Sound("/sound/Laser_Shoot42.wav")).getClip().loop(0);
        sound.play(true);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy) {
        this.gun.setProjectileSpawn(dx, dy);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy, Direction direction) {
        throw new UnsupportedOperationException();
    }

    public void place() {
        int x = GameMap.WIDTH - this.type.getWidth();
        int y = (int) (Math.random() * (GameMap.HEIGHT - this.type.getHeight()));
        this.reset(x, y);
    }
}
