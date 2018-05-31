package org.academiadecodigo.xenon;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

import javax.sound.sampled.Clip;

public class Game {

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;
    private World world;
    private ProjectileFactory projectileFactory;
    private EnemyShipFactory enemyShipFactory;
    private LivesScore livesScore;

    public Game() {
        this.collisionDetector = new CollisionDetector(this.player);
        this.world = new World(this.collisionDetector);
        this.projectileFactory = new ProjectileFactory(30, this.world);
        this.projectileFactory.init();
        this.gameMap = new GameMap();
        this.player = new PlayerShip(10, GameMap.HEIGHT / 2 - 30, collisionDetector, this, projectileFactory, world);
        this.enemyShipFactory = new EnemyShipFactory(30, collisionDetector, gameMap, this, world);
        this.enemyShipFactory.init();
        collisionDetector.add(this.player);
        this.livesScore = new LivesScore(GameMap.WIDTH + GameMap.PADDING, GameMap.PADDING, "0");
    }

    public void init() {
        (new Sound("")).getClip().loop(Clip.LOOP_CONTINUOUSLY);
        this.world.add(this.player);
        new Controller(this.player);
    }

    public void run() {
        while (this.isRunning()) {

            this.createShips();

            this.tick();

            //this.collisionDetector.collide();

            this.livesScore.setScore(this.player.score());

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void createShips() {
        if (Math.random() < 0.98) {
            return;
        }

        EnemyShip e = this.enemyShipFactory.get();

        if (e == null) {
            return;
        }

        e.show();
        e.reset(e.getX(), e.getY());
        this.register(e);
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    public void tick() {
        this.world.tick();
    }

    public void register(GameObject g) {
        this.world.add(g);
    }

    public ProjectileFactory getProjectileFactory() {
        return this.projectileFactory;
    }
}
