package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.Gun;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable, Scorable {

    private CollisionDetector collisionDetector;
    private ProjectileFactory factory;
    private Game game;
    private boolean shooting;

    public SpaceShip(int x, int y, int width, int height, CollisionDetector collisionDetector, Game game, String pathname) {
        super(x, y, width, height, pathname);
        this.collisionDetector = collisionDetector;
        this.game = game;
        this.factory = game.getProjectileFactory();
    }

    public void hit() {
        this.destroy();
    }

    public void shoot() {
        this.shooting = true;
    }

    public int score() {
        return 5;
    }

    public void addPoints(int points) {

    }
}
