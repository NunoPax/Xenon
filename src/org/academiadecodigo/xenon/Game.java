package org.academiadecodigo.xenon;

import java.util.List;
import java.util.LinkedList;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.gameobjects.*;

public class Game {

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;
    private List<GameObject> gameObjects;

    public Game() {
        this.gameMap = new GameMap();
        this.collisionDetector = new CollisionDetector(null);
        this.player = new PlayerShip(0, 0, collisionDetector, gameMap, this);
        gameObjects = new LinkedList<>();
        EnemyShip e1 = new EnemyShip(GameMap.WIDTH - 10, 10, collisionDetector, gameMap, this);
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

    public void tick() {
        this.player.tick();

        for (GameObject g : gameObjects) {
            g.tick();
        }
    }

    public void register(GameObject g) {
        this.gameObjects.add(g);
    }
}
