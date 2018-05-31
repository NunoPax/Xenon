package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.World;

import java.util.LinkedList;
import java.util.List;


public class EnemyShipFactory {

    private List<EnemyShip> enemyShips;
    private int maxShips;
    private World world;

    public EnemyShipFactory(int maxShips, World world) {
        this.maxShips = maxShips;
        this.enemyShips = new LinkedList<>();
        this.world = world;
    }


    public void init() {

        for (int i = 0; i < maxShips; i++) {
            int x = GameMap.WIDTH - EnemyShip.WIDTH; // GameMap.WIDTH - 10;
            int y = (int) (Math.random() * (GameMap.HEIGHT - EnemyShip.HEIGHT)); // (int) (Math.random() * GameMap.HEIGHT - 10 - 10) + 10;
            EnemyShip enemyShip = new EnemyShip(x, y, world, (Math.random() < 0.5) ? SpaceShipType.ENEMY : SpaceShipType.ENEMY_BIGGER,this);
            enemyShips.add(enemyShip);
        }
    }

    public EnemyShip get() {
        if (enemyShips.size() <= 0) {
            return null;
        }
        int x = GameMap.WIDTH - EnemyShip.WIDTH;
        int y = (int) (Math.random() * (GameMap.HEIGHT - EnemyShip.HEIGHT));
        EnemyShip e = this.enemyShips.remove(0);
        e.reset(x, y);
        return e;

    }

    public void offer(EnemyShip enemyShip) {
        this.enemyShips.add(enemyShip);

    }

    public boolean canGetNewEnemyShip() {
        if (enemyShips.size() > 0) {
            return true;

        }

        return false;
    }
}
