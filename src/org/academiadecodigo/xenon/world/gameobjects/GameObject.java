package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.Drawable;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.GameMap;

public abstract class GameObject implements Drawable, Movable, Destroyable, Disposable {

    private volatile Direction direction;
    private Direction heading;

    private Structure structure;

    private boolean destroyed;

    private boolean disposed;
    protected int speed = 8;

    public GameObject(int width, int height, String pathname) {
        this.structure = new Structure(0, 0, width, height, pathname);
    }

    public GameObject(int x, int y, int width, int height, String pathname) {
        this.structure = new Structure(x, y, width, height, pathname);
        this.destroyed = false;
    }

    public void show() {
        this.structure.draw();
    }

    public void hide() {
        this.structure.delete();
    }

    public void tick() {
        this.move();

        if (this.structure.isOutOfBounds()) {
            this.dispose();
        }

        this.structure.clamp();
    }

    public void move() {
        if (this.direction == null) {
            return;
        }

        this.direction.move(this.structure, speed);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setHeading(Direction heading) {
        this.heading = heading;
    }

    public Direction getHeading() {
        return this.heading;
    }

    public void destroy() {
        (new Sound("/sound/Explosion71.wav")).getClip().loop(0);
        this.destroyed = true;
        this.hide();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void reset(int x, int y) {
        this.structure.moveTo(x, y);
        this.destroyed = false;
        this.disposed = false;
    }

    /**
     * return true if the given GameObject overlaps this
     */
    public boolean overlaps(GameObject other) {
        return this.structure.overlaps(other.structure);
    }

    @Override
    public void dispose() {
        disposed = true;
        this.hide();
    }

    @Override
    public boolean isDisposed() {
        return disposed;
    }

    public int getX() {
        return this.structure.getX();
    }

    public int getY() {
        return this.structure.getY();
    }

    public void moveRelativeTo(GameObject other, int dx, int dy) {
        this.structure.moveRelativeTo(other.structure, dx, dy);
    }
}
