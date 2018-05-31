package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Direction;

public interface Shootable {
    void shoot();
    void setProjectileSpawn(int dx, int dy);
    void setProjectileSpawn(int dx, int dy, Direction direction);
}
