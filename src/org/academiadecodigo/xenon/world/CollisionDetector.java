package org.academiadecodigo.xenon.world;

import java.util.List;

import org.academiadecodigo.xenon.world.gameobjects.GameObject;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;

public class CollisionDetector {
    private PlayerShip playerShip;
    private List<GameObject> gameObjects;

    public CollisionDetector(GameObject gameObjects) {

    }

    public void add(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
        
    }

    /*public void collide(GameObject gameObject) {
        for ( GameObject)
        if(playerShip.overlaps(gameObject)){
            remove(gameObject);
            gameObject.isDestroyed();
        }
        if(gameObject.overlaps(playerShip)){

        }*/
    }

