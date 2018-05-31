package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public abstract class SpaceShip extends GameObject implements Shootable, Hitable, Scorable {

    private CollisionDetector collisionDetector;
    private ProjectileFactory factory;
    private Game game;
    private boolean shooting;

    public SpaceShip(int x, int y, int width, int height, CollisionDetector collisionDetector, GameMap gameMap, Game game, String pathname) {
        super(x, y, width, height, gameMap, pathname);
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
