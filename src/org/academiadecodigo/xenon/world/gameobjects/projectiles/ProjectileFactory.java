package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.World;

import java.util.LinkedList;
import java.util.Vector;
import java.util.List;

public class ProjectileFactory {

    private List<Projectile> projectiles;
    private int maxProjectiles;
    private World world;
    private ProjectileType type;

    public ProjectileFactory(int maxProjectiles, World world, ProjectileType type) {
        this.projectiles = new LinkedList<>();
        this.maxProjectiles = maxProjectiles;
        this.world = world;
        this.type = type;
    }

    public void init() {

        for (int i = 0; i < maxProjectiles; i++) {
            projectiles.add(new Projectile(type, world, this));
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
