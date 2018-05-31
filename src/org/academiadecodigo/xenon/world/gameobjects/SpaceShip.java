package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Gun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable, Scorable {


    public SpaceShip(int x, int y, SpaceShipType type, World world) {
        super(x, y, type.getWidth(), type.getHeight(), type.getPath());
    }

    public void hit() {
        this.destroy();
    }

    public void shoot() {
    }

    public int score() {
        return 5;
    }

    public void addPoints(int points) {

    }
}
