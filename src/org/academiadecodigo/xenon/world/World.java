package org.academiadecodigo.xenon.world;

import org.academiadecodigo.xenon.world.gameobjects.*;

import java.util.LinkedList;
import java.util.List;

public class World {
    private Boss boss1;
    private Boss boss2;
    private Boss boss3;
    private Boss boss4;

    private boolean defeated = false;

    private PlayerShip player;
    private CollisionDetector detector;
    private EnemyShipFactory enemyShipFactory;

    private List<GameObject> objects = new LinkedList<>();
    private List<GameObject> toBeAdded = new LinkedList<>();
    private List<GameObject> toBeRemoved = new LinkedList<>();

    public World() {
        this.detector = new CollisionDetector();
        this.enemyShipFactory = new EnemyShipFactory(20, this);
        this.enemyShipFactory.init();
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
        this.add(player);
        this.updateObjects();
    }

    public void tick() {
        if (this.player.score() >= 25 && this.boss1 == null) {
            this.boss1 = new Boss(BossShipType.random(), this);
        }

        if (this.player.score() >= 100 && this.boss1 != null && this.boss1.isDestroyed() && this.boss2 == null) {
            this.boss2 = new Boss(BossShipType.random(), this);
        }

        if (this.player.score() >= 200 && this.boss2 != null && this.boss2.isDestroyed() && this.boss3 == null) {
            this.boss3 = new Boss(BossShipType.random(), this);
        }

        if (this.player.score() >= 400 && this.boss3 != null && this.boss3.isDestroyed() && this.boss4 == null) {
            this.boss4 = new Boss(BossShipType.random(), this);
        }

        if (this.boss4 != null && this.boss4.isDestroyed()) {
            this.defeated = true;
        }

        this.createShips();
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

    public List<GameObject> overlaping(GameObject source) {
        return this.detector.overlaping(source);
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
        this.add(e);
    }

    public boolean isDefeated() {
        return false;
    }
}
