package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public class EnemyShip extends SpaceShip implements Scorable {

    private int score = 5;
    private Picture pic;


    public EnemyShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, collisionDetector, gameMap, game);
        this.pic = new Picture(x + GameMap.PADDING, y + GameMap.PADDING,"res/enemyShip.png");
        this.setHeading(Direction.LEFT);
        this.setColor(Color.RED);
    }

     public void show() {
        this.pic.draw();
    }

    public void hide() {
        this.pic.delete();
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
}
