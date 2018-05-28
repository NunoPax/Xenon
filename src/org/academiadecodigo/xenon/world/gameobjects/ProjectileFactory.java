package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.gameobjects.Projectile;

import java.util.LinkedList;
import java.util.List;

public class ProjectileFactory {

    private List<Projectile> projectiles;
    private int maxProjectile;
    private GameMap gameMap;


    public ProjectileFactory(int maxProjectiles) {
        this.maxProjectile = maxProjectiles;
        this.projectiles = new LinkedList<>();
    }

    public void init() {

        for (int i = 0; i < maxProjectile; i++) {

            int x = 0;
            int y = 0;
            Projectile projectile = new Projectile(x, y, gameMap);
            projectiles.add(projectile);
        }

    }

    public Projectile get() {
        if (projectiles.size() <= 0) {
            return null;
        }

        return this.projectiles.remove(0);
    }


    public void offer(Projectile projectile) {
        this.projectiles.add(projectile);
    }


    public boolean canGetNewProjectile() {
        if (projectiles.size() > 0) {
            return true;

        }

        return false;
    }

}
