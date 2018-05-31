package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.Explodable;
import org.academiadecodigo.xenon.world.gameobjects.GameObject;
import org.academiadecodigo.xenon.world.gameobjects.SpaceShip;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

public class Projectile extends GameObject implements Explodable {
    private ProjectileFactory factory;
    private SpaceShip creator;
    private World world;

    public Projectile(World world, ProjectileFactory factory) {
        super(22, 21, "res/star.png");
        this.world = world;
        this.factory = factory;
        this.speed = 12;
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
