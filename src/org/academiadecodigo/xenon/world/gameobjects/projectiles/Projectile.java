package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

public class Projectile extends GameObject implements Explodable {
    private ProjectileFactory factory;
    private SpaceShip creator;
    private World world;

    public Projectile(ProjectileType type, World world, ProjectileFactory factory) {
       super(type.getWidth(), type.getHeight(), type.getPath());
       this.world = world;
       this.factory = factory;
       this.speed = 12;
    }

    @Override
    public void tick() {
        super.tick();

        for (GameObject other : this.world.overlaping(this)) {
            if (other instanceof SpaceShip) {
                if ((this.creator instanceof EnemyShip || this.creator instanceof Boss) && !(other instanceof PlayerShip)) {
                    continue;
                }

                this.explode((SpaceShip) other);
            }
        }
    }

    public void setCreator(SpaceShip creator) {
        this.creator = creator;
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
        this.factory.offer(this);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.world.remove(this);
        this.factory.offer(this);
    }

    public void explode(SpaceShip target) {
        target.hit();

        if (target.isDestroyed()) {
            this.creator.addPoints(target.score());
        }

        this.destroy();
    }
}
