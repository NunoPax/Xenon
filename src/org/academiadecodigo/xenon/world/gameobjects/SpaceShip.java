package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.World;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable, Scorable {
    private World world;
    private Explosion explosion;

    public SpaceShip(int x, int y, SpaceShipType type, World world) {
        super(x, y, type.getWidth(), type.getHeight(), type.getPath());
        this.world = world;
        this.explosion = new Explosion(this.world);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.explosion.reset(this.getX(), this.getY());
        this.world.add(this.explosion);
    }

    public void hit() {
        this.destroy();
    }

    public void shoot() {
    }

    public int score() {
        return 5;
    }

    public void addPoints(int points) {

    }
}
