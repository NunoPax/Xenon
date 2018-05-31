package org.academiadecodigo.xenon.world;

import org.academiadecodigo.xenon.world.gameobjects.Structure;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public void move(Structure structure, int distance) {
        int dx = 0;
        int dy = 0;

        switch (this) {
            case UP:
                dy -= distance;
                break;
            case DOWN:
                dy += distance;
                break;
            case LEFT:
                dx -= distance;
                break;
            case RIGHT:
                dx += distance;
                break;
        }

        structure.translate(dx, dy);
    }
}
