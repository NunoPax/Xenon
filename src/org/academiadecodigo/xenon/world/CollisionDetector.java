package org.academiadecodigo.xenon.world;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.academiadecodigo.xenon.world.gameobjects.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.GameObject;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;
import org.academiadecodigo.xenon.world.gameobjects.Projectile;

public class CollisionDetector {
    private List<GameObject> gameObjects;
    private PlayerShip playerShip;

    public CollisionDetector(PlayerShip playerShip) {
        gameObjects = new Vector<>();
        this.playerShip = playerShip;
    }

    public void add(GameObject gameObject) {

        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        //this.gameObjects.remove(gameObject);
        Iterator<GameObject> it = gameObjects.iterator();
        while(it.hasNext()) {
            GameObject o = it.next();

            if (o == gameObject) {
                it.remove();
                return;
            }
        }
    }

    public void collide() {
        for (GameObject object1 : gameObjects) {
            if (object1.isDestroyed()) {
                continue;
            }

            for (GameObject object2 : gameObjects) {
                if (object2.isDestroyed()) {
                    continue;
                }

                if (object1 instanceof Projectile && object2 instanceof PlayerShip) {
                    if (object1.overlaps(object2)) {
                        ((PlayerShip) object2).hit();
                        object1.destroy();
                    }
                }
                if (object1 instanceof Projectile && object2 instanceof EnemyShip) {
                    if (object1.overlaps(object2)) {
                        ((EnemyShip) object2).hit();
                        object1.destroy();
                    }
                }
                if (object1 instanceof EnemyShip && object2 instanceof PlayerShip) {
                    if (object1.overlaps(object2)) {
                        ((PlayerShip) object2).hit();
                        ((EnemyShip) object1).hit();
                    }
                }
            }
        }

    }
}
