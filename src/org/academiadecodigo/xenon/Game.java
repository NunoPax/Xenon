package org.academiadecodigo.xenon;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Vector;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.gameobjects.*;

import javax.sound.sampled.Clip;

public class Game {

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;
    private List<GameObject> gameObjects;
    private ProjectileFactory projectileFactory;
    private EnemyShipFactory enemyShipFactory;
    private LivesScore livesScore;
    private int totalScore;

    public Game() {
        this.projectileFactory = new ProjectileFactory(20);
        this.projectileFactory.init();
        this.gameMap = new GameMap();
        this.collisionDetector = new CollisionDetector(this.player);
        this.player = new PlayerShip(0, 0, collisionDetector, gameMap, this);
        gameObjects = new Vector<>();
        this.enemyShipFactory = new EnemyShipFactory(20, collisionDetector, gameMap, this);
        this.enemyShipFactory.init();
        collisionDetector.add(this.player);
        Controller controller = new Controller(this.player);
        this.livesScore = new LivesScore(GameMap.WIDTH + GameMap.PADDING, GameMap.PADDING, "0");
    }

    public void init() {
        this.player.show();
        (new Sound("")).getClip().loop(Clip.LOOP_CONTINUOUSLY);

        for (GameObject g : gameObjects) {
            g.show();
        }
    }

    public void run() {
        while (this.isRunning()) {

            this.addPoints();

            this.removeDestroyed();

            this.createShips();

            this.tick();

            this.collisionDetector.collide();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void addPoints() {
        Iterator<GameObject> it = this.gameObjects.iterator();
        while (it.hasNext()) {
            GameObject o = it.next();

            if (o instanceof EnemyShip && o.isDestroyed()) {
                totalScore += ((EnemyShip) o).score();
            }
        }
        livesScore.setScore(totalScore);
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

    private void removeDestroyed() {
        Iterator<GameObject> it = this.gameObjects.iterator();
        while (it.hasNext()) {
            GameObject o = it.next();

            if (o.isDestroyed() || o.isDisposed()) {
                it.remove();
                this.collisionDetector.remove(o);

                if (o instanceof Projectile) {
                    this.projectileFactory.offer((Projectile) o);
                } else if (o instanceof EnemyShip) {
                    this.enemyShipFactory.offer((EnemyShip) o);
                }
            }
        }

/*        it = gameObjects.iterator();
        while (it.hasNext()) {
            GameObject cursor = (GameObject) it.next();

            if (cursor.isDestroyed()) {
                if (cursor instanceof Projectile) {
                    it.remove();
                    projectileFactory.offer((Projectile) cursor);
                } else if (cursor instanceof EnemyShip) {
                    it.remove();
                    //projectileFactory.offer((EnemyShip) cursor);
                }

            }
        }*/
    }

    public void tick() {
        this.player.tick();

        //for (Projectile p : this.projectiles) {
        //    p.tick();
        //}

        Iterator<GameObject> it = this.gameObjects.iterator();
        while (it.hasNext()) {
            GameObject o = it.next();
            o.tick();
        }
    }

    public void register(GameObject g) {
        this.gameObjects.add(g);
        this.collisionDetector.add(g);
    }

    public ProjectileFactory getProjectileFactory() {
        return this.projectileFactory;
    }
}
