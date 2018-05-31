package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.World;

import java.util.LinkedList;
import java.util.Vector;
import java.util.List;

public class ProjectileFactory {

    private List<Projectile> projectiles;
    private int maxProjectile;
    private GameMap gameMap;
    private World world;
    private String pathname;

    public ProjectileFactory(int maxProjectiles, World world) {
        this.maxProjectile = maxProjectiles;
        this.projectiles = new LinkedList<>();
        this.world = world;
    }

    public ProjectileFactory(int maxProjectile, World world, String pathname) {
        this.maxProjectile = maxProjectile;
        this.projectiles = new LinkedList<>();
        this.world = world;
        this.pathname = pathname;
    }

    public void init() {

        for (int i = 0; i < maxProjectile; i++) {
            if (pathname == null) {
                projectiles.add(new Projectile(world, this));
            } else {
                projectiles.add(new Projectile(world, this, pathname));
            }
        }

    }

    public Projectile get(int x, int y) {
        if (projectiles.size() <= 0) {
            return null;
        }

        Projectile p = this.projectiles.remove(0);
        p.reset(x, y);
        p.show();
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
