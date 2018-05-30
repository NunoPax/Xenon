package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.Controllable;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public class PlayerShip extends SpaceShip implements Controllable {

    public PlayerShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, 57, 61, collisionDetector, gameMap, game, "res/playerShip.png");
        this.setHeading(Direction.RIGHT);
        this.show();
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
                dy = -6;
                break;
            case DOWN:
                dy = 6;
                break;
            case LEFT:
                dx = -6;
                break;
            case RIGHT:
                dx = 6;
                break;
        }

        if (this.canBeTranslatedTo(dx, dy)) {
            this.translate(dx, dy);
        }
    }

    @Override
    public void setShooting(boolean shooting) {
        super.shoot();
    }

    @Override
    public boolean isControllable() {
        return !this.isDestroyed();
    }
}
