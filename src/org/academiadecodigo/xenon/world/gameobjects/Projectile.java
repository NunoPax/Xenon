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

    private int x = 0;
    private int y = 0;

    private final int WIDTH = 30;
    private final int HEIGTH = 29;

    private Picture img = new Picture(0, 0, "res/star.png");

    public Projectile(World world, ProjectileFactory factory) {
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

        if (this.x + this.WIDTH >= GameMap.WIDTH) {
            this.dispose();
        }

        if (this.x + this.WIDTH < 0) {
            this.dispose();
        }
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
    public void setX(int x) {
        this.x = x;
        this.img.translate(x - this.img.getX(), 0);
    }

    @Override
    public void setY(int y) {
        this.y = y;
        this.img.translate(0, y - this.img.getY());
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

    @Override
    public void move() {
        if (this.direction == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (this.direction) {
            case UP:
                dy = -8;
                break;
            case DOWN:
                dy = 8;
                break;
            case LEFT:
                dx = -8;
                break;
            case RIGHT:
                dx = 8;
                break;
        }

        this.translate(dx, dy);
    }

    @Override
    public void translate(int dx, int dy) {
        this.setX(this.x + dx);
        this.setY(this.y + dy);
    }

    @Override
    public boolean overlaps(GameObject other) {
        // Here we check if this's start comes after other's end
        // or if this's end comes before other's start
        boolean disjoint = this.x >= other.getX() + other.getWidth()
                || this.x + this.WIDTH <= other.getX()
                || this.y >= other.getY() + other.getHeight()
                || this.y + this.HEIGTH <= other.getY();

        return !disjoint;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGTH;
    }

    @Override
    public void reset(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.world.add(this);
    }
}


