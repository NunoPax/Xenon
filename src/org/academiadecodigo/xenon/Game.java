package org.academiadecodigo.xenon;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Vector;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.gameobjects.*;

public class Game {

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;
    private List<GameObject> gameObjects;
    private ProjectileFactory projectileFactory;

    public Game() {
        this.projectileFactory = new ProjectileFactory(20);
        this.projectileFactory.init();
        this.gameMap = new GameMap();
        this.collisionDetector = new CollisionDetector(this.player);
        this.player = new PlayerShip(0, 0, collisionDetector, gameMap, this);
        gameObjects = new Vector<>();
        EnemyShip e1 = new EnemyShip(GameMap.WIDTH - 10, 10, collisionDetector, gameMap, this);
        collisionDetector.add(e1);
        collisionDetector.add(this.player);
        gameObjects.add(e1);
        Controller controller = new Controller(this.player);
    }

    public void init() {
        this.player.show();

        for (GameObject g : gameObjects) {
            g.show();
        }
    }

    public void run() {
        while (this.isRunning()) {

            this.tick();

            this.collisionDetector.collide();

            this.removeDestroyed();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    private void removeDestroyed() {
        Iterator<GameObject> it = this.gameObjects.iterator();
        while (it.hasNext()) {
            GameObject o = it.next();

            if (o.isDestroyed()) {
                it.remove();
                this.collisionDetector.remove(o);

                if (o instanceof Projectile) {
                    this.projectileFactory.offer((Projectile) o);
                } else if (o instanceof EnemyShip) {
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
