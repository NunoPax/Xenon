package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;

public class EnemyProjectile extends Projectile {
    public EnemyProjectile(int x, int y, GameMap gameMap) {
        super(x, y, gameMap, "res/enemyProjectile");
    }
}
