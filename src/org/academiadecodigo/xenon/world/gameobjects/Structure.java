package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;

public class Structure {
    private Picture img;
    private int x;
    private int y;
    private int width;
    private int height;

    public Structure(int x, int y, int width, int height, String pathname) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.img = new Picture(
                x + GameMap.PADDING,
                y + GameMap.PADDING,
                pathname
        );
    }

    public void moveTo(int x, int y) {
        int dx = x - this.x;
        int dy = y - this.y;
        this.translate(dx, dy);
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        this.img.translate(dx, dy);
    }

    public boolean overlaps(Structure other) {
        // Here we check if this's start comes after other's end
        // or if this's end comes before other's start
        boolean disjoint = this.x >= other.x + other.width
                || this.x + this.width <= other.x
                || this.y >= other.y + other.height
                || this.y + this.height <= other.y;

        return !disjoint;
    }

    public void draw() {
        this.img.draw();
    }

    public void delete() {
        this.img.delete();
    }

    public void moveRelativeTo(Structure other, int dx, int dy) {
        this.moveTo(other.x + dx, other.y + dy);
    }

    public boolean isOutOfBounds() {
        return this.x + this.width < 0 || this.x > GameMap.WIDTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
