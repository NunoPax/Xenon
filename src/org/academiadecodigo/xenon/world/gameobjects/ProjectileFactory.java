package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.Projectile;

import java.util.Vector;
import java.util.List;

public class ProjectileFactory {

    private List<Projectile> projectiles;
    private int maxProjectile;
    private GameMap gameMap;
    private World world;


    public ProjectileFactory(int maxProjectiles, World world) {
        this.maxProjectile = maxProjectiles;
        this.projectiles = new Vector<>();
        this.world = world;
    }

    public void init() {

        for (int i = 0; i < maxProjectile; i++) {

            int x = 0;
            int y = 0;
            Projectile projectile = new Projectile(x, y, gameMap, world, this);
            projectiles.add(projectile);
        }

    }

    public Projectile get(int x, int y) {
        if (projectiles.size() <= 0) {
            return null;
        }

        Projectile p = this.projectiles.remove(0);
        p.reset(x, y);
        return p;
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
