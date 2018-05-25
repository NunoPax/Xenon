package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Drawable;
import org.academiadecodigo.xenon.world.Direction;

public abstract class GameObject implements Drawable, Movable, Destroyable {

    private GameMap gameMap;
    private Direction direction;

    private int x;
    private int y;

    private int width = 10;
    private int height = 10;

    private Rectangle rect;

    public GameObject(int x, int y, GameMap gameMap) {
        this.rect = new Rectangle(x, y, this.width, this.height);
        this.gameMap = gameMap;
    }

    public void show() {
        this.rect.fill();
    }

    public void hide() {
    }

    public void tick() {
        if (this.direction == null) {
            return;
        }

        switch (this.direction) {
        case UP:
            if (!this.gameMap.isInBounds(this.x,
                                         this.y - 10,
                                         this.width,
                                         this.height)) {
                return;
            }

            this.y -= 10;
            this.rect.translate(0, -10);
            this.direction = null;
            break;
        case DOWN:
            if (!this.gameMap.isInBounds(this.x,
                                         this.y + 10,
                                         this.width,
                                         this.height)) {
                return;
            }

            this.y += 10;
            this.rect.translate(0, 10);
            this.direction = null;
            break;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getHeading() {
        return null;
    }

    public void destroy() {
    }

    public boolean isDestroyed() {
        return false;
    }

    /**
     *
     * return true if the given GameObject overlaps this
     */
    public boolean overlaps(GameObject other) {
        // Here we check if this's start comes after other's end
        // or if this's end comes before other's start
        boolean disjoint = this.x > other.x + other.width
            || this.x + this.width < other.x
            || this.y > other.y + other.height
            || this.y + this.height < other.y;

        return !disjoint;
    }
}
