package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public class PlayerShip extends SpaceShip {

    private Picture pic;

    public PlayerShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, collisionDetector, gameMap, game);
        this.pic = new Picture(x + GameMap.PADDING, y + GameMap.PADDING, "res/playerShip.png");
        this.setHeading(Direction.RIGHT);
    }

    public void show() {
        //this.pic.draw();
    }

    public void hide() {
        //this.pic.delete();
    }

    @Override
    public void move() {
        if (this.getDirection() == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (this.getDirection()) {
            case UP:
                dy = -10;
                break;
            case DOWN:
                dy = 10;
                break;
            case LEFT:
                dx = -10;
                break;
            case RIGHT:
                dx = 10;
                break;
        }

        this.setDirection(null);

        if (this.canBeTranslatedTo(dx, dy)) {
            this.translate(dx, dy);
        }
    }
}
