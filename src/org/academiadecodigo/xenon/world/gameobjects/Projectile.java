package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.World;

public class Projectile extends GameObject implements Explodable {
    private ProjectileFactory factory;
    private SpaceShip creator;
    private World world;

    private Direction direction;

    private Picture img = new Picture(0, 0, "res/star.png");

    public Projectile(World world, ProjectileFactory factory) {
        super("res/star.png");
        this.world = world;
        this.factory = factory;
    }


//    public Projectile(int x, int y, GameMap gameMap, World world, ProjectileFactory factory) {
//        super(x, y, 30, 29, gameMap, "res/star.png");
//        this.world = world;
//        this.factory = factory;
//    }


    @Override
    public void tick() {
        this.move();
    }

    @Override
    public void show() {
        this.img.draw();
    }

    @Override
    public void hide() {
        this.img.delete();
    }

    public void setCreator(SpaceShip creator) {
        this.creator = creator;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

