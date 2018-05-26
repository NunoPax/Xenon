package org.academiadecodigo.xenon.world;

import java.util.List;

import org.academiadecodigo.xenon.world.gameobjects.GameObject;

public class CollisionDetector {
    private List<GameObject> gameObjects;

    public CollisionDetector(GameObject gameObjects) {

    }

    public void add(GameObject gameObject) {

        this.gameObjects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        if(gameObject.isDestroyed()){
            this.gameObjects.remove(gameObject);
        }
    }

    public void collide() {

    }
}
