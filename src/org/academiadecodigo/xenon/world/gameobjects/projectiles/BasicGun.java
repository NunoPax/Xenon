package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.Shootable;
import org.academiadecodigo.xenon.world.gameobjects.SpaceShip;

public class BasicGun implements Shootable {
    private World world;
    private ProjectileFactory factory;
    private SpaceShip owner;
    private Direction heading;

    private int dx;
    private int dy;

    public BasicGun(SpaceShip owner, World world, int maxProjectiles, ProjectileType type) {
        this.world = world;
        this.owner = owner;
        this.factory = new ProjectileFactory(maxProjectiles, world, type);
        this.factory.init();
    }

    @Override
    public void setProjectileSpawn(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setProjectileSpawn(int dx, int dy, Direction heading) {
        this.dx = dx;
        this.dy = dy;
        this.heading = heading;
    }

    @Override
    public void shoot() {
        if (this.owner.isDestroyed() || this.owner.isDisposed()) {
            return;
        }

        Projectile p = this.factory.get(0, 0);

        if (p == null) {
            return;
        }

        p.moveRelativeTo(this.owner, this.dx, this.dy);
        p.setDirection(this.heading);
        p.setCreator(this.owner);
        this.world.add(p);
    }
}
