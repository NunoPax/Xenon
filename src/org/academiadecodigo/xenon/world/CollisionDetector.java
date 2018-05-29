package org.academiadecodigo.xenon.world;

import java.util.LinkedList;
import java.util.List;

import org.academiadecodigo.xenon.world.gameobjects.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.GameObject;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;
import org.academiadecodigo.xenon.world.gameobjects.Projectile;

public class CollisionDetector {
    private List<GameObject> gameObjects;
    private PlayerShip playerShip;

    public CollisionDetector(PlayerShip playerShip) {
        gameObjects = new LinkedList<GameObject>();
        this.playerShip = playerShip;
    }

    public void add(GameObject gameObject) {

        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {

            this.gameObjects.remove(gameObject);
    }

    public void collide() {
        for (GameObject object1 : gameObjects) {
            for (GameObject object2 : gameObjects) {
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
