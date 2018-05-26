package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
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

    private boolean destroyed;

    private Rectangle rect;

    public GameObject(int x, int y, GameMap gameMap) {
        this.rect = new Rectangle(x + GameMap.PADDING, y + GameMap.PADDING, this.width, this.height);
        this.x = x;
        this.y = y;
        this.gameMap = gameMap;
        this.destroyed = false;
    }

    public void show() {
        this.rect.fill();
    }

    public void hide() {
        this.rect.delete();
    }

    public void tick() {
        if (this.direction == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (this.direction) {
        case UP:
            dy = -10;
            break;
        case DOWN:
            dy = 10;
            break;
        case LEFT:
            dx = -10;
            break;
        case RIGHT:
            dx = 10;
            break;
        }

        this.direction = null;

        if (this.canBeTranslatedTo(dx, dy)) {
            this.translate(dx, dy);
        }
    }

    public boolean canBeTranslatedTo(int dx, int dy) {
        return this.gameMap.isInBounds(this.x + dx,
                                       this.y + dy,
                                       this.width,
                                       this.height);
    }

    public void translate(int dx, int dy) {
        this.rect.translate(dx, 0);
        this.x += dx;

        this.rect.translate(0, dy);
        this.y += dy;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setColor(Color color) {
        this.rect.setColor(color);
    }

    public Direction getHeading() {
        return null;
    }

    public void destroy() {
        this.destroyed = true;
        this.hide();
    }

    public boolean isDestroyed() {
        return destroyed;
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
