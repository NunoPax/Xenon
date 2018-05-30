package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.world.World;

public class EnemyShip extends SpaceShip implements Scorable {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private int score = 5;
    private World world;
    private EnemyShipFactory enemyShipFactory;



    public EnemyShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game, World world, EnemyShipFactory enemyShipFactory) {
        super(x, y, WIDTH, HEIGHT, collisionDetector, gameMap, game, "res/enemyShip.png");
        this.setHeading(Direction.LEFT);
        this.world = world;
        this.enemyShipFactory = enemyShipFactory;
    }

    @Override
    public void tick() {
        this.setDirection(this.getHeading());
        super.tick();
    }

    @Override
    public int score(){
       return score;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.world.remove(this);
        this.enemyShipFactory.offer(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.world.remove(this);
        this.enemyShipFactory.offer(this);
    }
}
