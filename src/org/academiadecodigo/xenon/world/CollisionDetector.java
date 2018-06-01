package org.academiadecodigo.xenon.world;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.gameobjects.ships.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.ships.PlayerShip;
import org.academiadecodigo.xenon.world.gameobjects.ships.SpaceShip;

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
        this.gameObjects.remove(gameObject);
    }

    public void collide() {
        for (GameObject object1 : gameObjects) {
            if (object1.isDestroyed() || object1.isDisposed()) {
                continue;
            }

            for (GameObject object2 : gameObjects) {
                if (object2.isDestroyed() || object2.isDisposed()) {
                    continue;
                }

                if (object1 instanceof Projectile && object2 instanceof PlayerShip) {
                    if (object1.overlaps(object2)) {
                        ((Projectile) object1).explode((SpaceShip) object2);
                    }
                }

                if (object1 instanceof Projectile && object2 instanceof EnemyShip) {
                    if (object1.overlaps(object2)) {
                        ((Projectile) object1).explode((SpaceShip) object2);
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

    public List<GameObject> overlaping(GameObject objct) {
        List<GameObject> acumulator = new LinkedList<>();
        for(GameObject object1 : gameObjects){
            if(objct.overlaps(object1)){
                acumulator.add(object1);
            }
        }
        return gameObjects;
    }
}
