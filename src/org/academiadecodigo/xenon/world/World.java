package org.academiadecodigo.xenon.world;

import org.academiadecodigo.xenon.world.gameobjects.*;

import java.util.LinkedList;
import java.util.List;

public class World {
    private BackgroundStar[] stars = new BackgroundStar[30];

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

    private int chanceOfSpawnEnemy = 1;

    public World() {
        this.detector = new CollisionDetector();
        this.enemyShipFactory = new EnemyShipFactory(100, this);
        this.enemyShipFactory.init();
        this.init();
    }

    private void init() {
        for (int i = 0; i < stars.length; i++) {
            stars[i] = BackgroundStar.get(this);
        }
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
        this.add(player);
        this.updateObjects();
    }

    public void tick() {
        if (this.player.score() >= 50 && this.boss1 == null) {
            this.boss1 = new Boss(BossShipType.random(), this, 15);
        }

        if (this.player.score() >= 200 && this.boss1 != null && this.boss1.isDestroyed() && this.boss2 == null) {
            this.boss2 = new Boss(BossShipType.random(), this, 30);
            chanceOfSpawnEnemy = 2;
        }

        if (this.player.score() >= 400 && this.boss2 != null && this.boss2.isDestroyed() && this.boss3 == null) {
            this.boss3 = new Boss(BossShipType.random(), this, 45);
            chanceOfSpawnEnemy = 3;
        }

        if (this.player.score() >= 800 && this.boss3 != null && this.boss3.isDestroyed() && this.boss4 == null) {
            this.boss4 = new Boss(BossShipType.random(), this, 60);
        }

        if (this.boss4 != null && this.boss4.isDestroyed()) {
            this.defeated = true;
        }

        this.createShips();
        this.updateObjects();
        this.tickAll();
    }

    private void tickAll() {
        for (BackgroundStar star : stars) {
            //star.hide();
            star.tick();
            star.show();
        }

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
        if ((int) (Math.random() * 100) < (100 - chanceOfSpawnEnemy)) {
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
        return defeated;
    }

    public boolean killedBoss(int i) {
        switch(i) {
        case 1:
            return boss1 != null && boss1.isDestroyed();
        case 2:
            return boss2 != null && boss2.isDestroyed();
        case 3:
            return boss3 != null && boss3.isDestroyed();
        case 4:
            return boss4 != null && boss4.isDestroyed();
        }
        return false;
    }
}
