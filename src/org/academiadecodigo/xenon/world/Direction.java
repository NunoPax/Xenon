package org.academiadecodigo.xenon.world;

import org.academiadecodigo.xenon.world.gameobjects.Structure;

public enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    NORTH_WEST,
    NORTH_EAST,
    SOUTH_WEST,
    SOUTH_EAST;

    public void move(Structure structure, int distance) {
        int dx = 0;
        int dy = 0;

        switch (this) {
            case NORTH:
                dy -= distance;
                break;
            case SOUTH:
                dy += distance;
                break;
            case WEST:
                dx -= distance;
                break;
            case EAST:
                dx += distance;
                break;
            case NORTH_WEST:
                dy -= distance;
                dx -= distance;
                break;
            case NORTH_EAST:
                dy -= distance;
                dx += distance;
                break;
            case SOUTH_WEST:
                dy += distance;
                dx -= distance;
                break;
            case SOUTH_EAST:
                dy += distance;
                dx += distance;
                break;
        }

        structure.translate(dx, dy);
    }
}
