package org.academiadecodigo.xenon.world.gameobjects.projectiles;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.Shootable;
import org.academiadecodigo.xenon.world.gameobjects.SpaceShip;

public class TriGun implements Shootable {
    private BasicGun gun1;
    private BasicGun gun2;
    private BasicGun gun3;

    public TriGun(SpaceShip owner, World world, int maxProjectiles, ProjectileType type) {
        this.gun1 = new BasicGun(owner, world, maxProjectiles, type);
        this.gun2 = new BasicGun(owner, world, maxProjectiles, type);
        this.gun3 = new BasicGun(owner, world, maxProjectiles, type);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy) {
        this.gun1.setProjectileSpawn(dx, dy - 40, Direction.NORTH_EAST);
        this.gun2.setProjectileSpawn(dx, dy, Direction.EAST);
        this.gun3.setProjectileSpawn(dx, dy + 40, Direction.SOUTH_EAST);
    }

    @Override
    public void setProjectileSpawn(int dx, int dy, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void shoot() {
        this.gun1.shoot();
        this.gun2.shoot();
        this.gun3.shoot();
    }
}
