package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.xenon.controller.Handler;
import org.academiadecodigo.xenon.controller.KeyboardListener;
import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.factories.EnemyShipFactory;
import org.academiadecodigo.xenon.world.factories.ProjectileFactory;
import org.academiadecodigo.xenon.world.gameobjects.ships.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.ships.PlayerShip;

import javax.sound.sampled.Clip;

public class Game implements Handler{

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;
    private World world;
    private ProjectileFactory projectileFactory;
    private EnemyShipFactory enemyShipFactory;
    private LivesScore livesScore;
    private KeyboardListener listener;

    public Game(KeyboardListener listener) {
        this.collisionDetector = new CollisionDetector(this.player);
        this.world = new World(this.collisionDetector);
        this.projectileFactory = new ProjectileFactory(30, this.world);
        this.projectileFactory.init();
        this.gameMap = new GameMap();
        this.player = new PlayerShip(0, 0, collisionDetector, this, projectileFactory, world);
        this.enemyShipFactory = new EnemyShipFactory(30, collisionDetector, gameMap, this, world);
        this.enemyShipFactory.init();
        collisionDetector.add(this.player);
        this.livesScore = new LivesScore(GameMap.WIDTH + GameMap.PADDING, GameMap.PADDING, "0");
        this.listener = listener;
    }

    public void init() {
        (new Sound("")).getClip().loop(Clip.LOOP_CONTINUOUSLY);
        this.world.add(this.player);
        listener.setHandler(this);
    }

    public void run() {
        init();
        while (this.isRunning()) {

            this.createShips();

            this.tick();

            this.collisionDetector.collide();

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

    @Override
    public void handlePressed(KeyboardEvent key) {
        switch (key.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                if (player.isControllable()) {
                    this.player.setShooting(true);
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void handleReleased(KeyboardEvent keyEvent) {
        if (!this.player.isControllable()) {
            return;
        }
        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(null);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(null);
                break;
        }
    }
}
