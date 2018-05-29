package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Drawable;
import org.academiadecodigo.xenon.world.Direction;

public abstract class GameObject implements Drawable, Movable, Destroyable {

    private GameMap gameMap;
    private Direction direction;
    private Direction heading;

    private int x;
    private int y;

    private int width = 10;
    private int height = 10;

    private boolean destroyed;

    //private Rectangle rect;
    private Picture ship;

    public GameObject(int x, int y, GameMap gameMap) {
        this.ship = new Picture(x + GameMap.PADDING, y + GameMap.PADDING,"res/playerShip.png");
        this.x = x;
        this.y = y;
        this.gameMap = gameMap;
        this.destroyed = false;
    }

    public void show() {
        this.ship.draw();
    }

    public void hide() {
        this.ship.delete();
    }

    public void tick() {
        this.move();

        if (this.x + this.width >= +GameMap.WIDTH) {
            this.destroy();
        }

        if (this.x + this.width < 0) {
            this.destroy();
        }
    }

    public void move() {
        if (this.direction == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (this.direction) {
            case UP:
                dy = -5;
                break;
            case DOWN:
                dy = 5;
                break;
            case LEFT:
                dx = -5;
                break;
            case RIGHT:
                dx = 5;
                break;
        }

        this.translate(dx, dy);
    }

    public boolean canBeTranslatedTo(int dx, int dy) {
        return this.gameMap.isInBounds(this.x + dx,
                this.y + dy,
                this.width,
                this.height);
    }

    public void translate(int dx, int dy) {
        this.ship.translate(dx, 0);
        this.x += dx;

        this.ship.translate(0, dy);
        this.y += dy;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setColor(Color color) {
        //this.ship.setColor(color);
    }

    public void setHeading(Direction heading) {
        this.heading = heading;
    }

    public Direction getHeading() {
        return this.heading;
    }

    public void destroy() {
        this.destroyed = true;
        this.hide();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setX(int x) {
        this.ship.translate(x - this.x, 0);
        this.x = x;
    }

    public void setY(int y) {
        this.ship.translate(0, y - this.y);
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public GameMap getGameMap() {
        return this.gameMap;
    }

    public void reset(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.destroyed = false;
    }

    /**
     * return true if the given GameObject overlaps this
     */
    public boolean overlaps(GameObject other) {
        // Here we check if this's start comes after other's end
        // or if this's end comes before other's start
        boolean disjoint = this.x >= other.x + other.width
                || this.x + this.width <= other.x
                || this.y >= other.y + other.height
                || this.y + this.height <= other.y;

        return !disjoint;
    }
}
