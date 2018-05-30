package org.academiadecodigo.xenon.world;

import org.academiadecodigo.xenon.world.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class World {
    private CollisionDetector detector;

    private List<GameObject> objects = new LinkedList<>();
    private List<GameObject> toBeAdded = new LinkedList<>();
    private List<GameObject> toBeRemoved = new LinkedList<>();

    public World(CollisionDetector detector) {
        this.detector = detector;
    }

    public void tick() {
        this.updateObjects();
        this.tickAll();
    }

    private void tickAll() {
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void add(GameObject object) {
        this.toBeAdded.add(object);
        this.detector.add(object);
    }

    public void remove(GameObject object) {
        this.toBeRemoved.add(object);
    }

    public void updateObjects() {
        this.objects.removeAll(this.toBeRemoved);

        for (GameObject object : this.toBeRemoved) {
            detector.remove(object);
        }

        this.toBeRemoved.clear();

        this.objects.addAll(this.toBeAdded);
        this.toBeAdded.clear();
    }
}
