package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.BasicGun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.TriGun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileType;

import org.academiadecodigo.xenon.sound.*;

public class Boss extends SpaceShip implements Scorable {
    private World world;
    private int hitpoints;
    private int height;

    private Shootable gun1;
    private Shootable gun2;
    private Shootable gun3;

    private long timestamp = System.currentTimeMillis();
    private long cooldown = 1500;

    private Sound sound = new Sound(GameSound.ENEMY_LASER);

    public Boss(BossShipType type, World world) {
        super(0, 0, type, world);
        this.world = world;
        this.hitpoints = 12;
        this.world.add(this);
        this.reset(GameMap.WIDTH - type.getWidth(), 0);
        this.show();
        this.setDirection(Direction.SOUTH);
        this.speed = 1;
        this.height = type.getHeight();

        this.gun1 = new BasicGun(this, this.world, 3, ProjectileType.CIRCLE);
        gun1.setProjectileSpawn(-60, -120, Direction.WEST);
        this.gun2 = new BasicGun(this, this.world, 3, ProjectileType.CIRCLE);
        gun2.setProjectileSpawn(-60, 0, Direction.WEST);
        this.gun3 = new BasicGun(this, this.world, 3, ProjectileType.CIRCLE);
        gun3.setProjectileSpawn(-60, 120, Direction.WEST);
    }

    @Override
    public void tick() {
        super.tick();


        this.shoot();

        if (this.getY() + height > GameMap.HEIGHT) {
            this.setDirection(Direction.NORTH);
        }

        if (this.getY() < 0) {
            this.setDirection(Direction.SOUTH);
        }

        this.clamp();
    }

    @Override
    public void hit() {
        if (hitpoints < 0) {
            this.destroy();
            return;
        }

        hitpoints--;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.world.remove(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
    }

    @Override
    public int score() {
        return 25;
    }

    @Override
    public void shoot() {
        long now = System.currentTimeMillis();

        if (now < timestamp + cooldown) {
            return;
        }

        this.timestamp = now;
        this.gun1.shoot();
        this.gun2.shoot();
        this.gun3.shoot();
        //(new Sound("/sound/Laser_Shoot42.wav")).getClip().loop(0);
        sound.play(true);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy) {

    }

    @Override
    public void setProjectileSpawn(int dx, int dy, Direction direction) {

    }
}
