package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.World;

public class Projectile extends GameObject implements Explodable {
    private World world;
    private ProjectileFactory factory;
    private SpaceShip creator;

    public Projectile(int x, int y, GameMap gameMap, World world, ProjectileFactory factory) {
        super(x, y, 30, 29, gameMap, "res/star.png");
        this.world = world;
        this.factory = factory;
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
    }
}


