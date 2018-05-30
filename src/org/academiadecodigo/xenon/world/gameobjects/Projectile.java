package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.World;

public class Projectile extends GameObject {
    private World world;
    private ProjectileFactory factory;

    public Projectile(int x, int y, GameMap gameMap, World world, ProjectileFactory factory) {
        super(x, y, 30, 29, gameMap, "res/star.png");
        this.world = world;
        this.factory = factory;
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
}


