package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public class EnemyShip extends SpaceShip implements Scorable {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private int count = 12;
    private int score = 5;

    public EnemyShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, WIDTH, HEIGHT, collisionDetector, gameMap, game, "res/enemyShip.png");
        this.setHeading(Direction.LEFT);
        this.setColor(Color.RED);
    }

    @Override
    public void tick() {
        this.setDirection(this.getHeading());
        if (this.count == 0) {
            this.shoot();
            this.count = 100;
        }
        count--;
        super.tick();
    }

    @Override
    public int score(){
       return score;
    }
}
