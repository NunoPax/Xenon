package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.Game;

public class EnemyShip extends SpaceShip {

    public EnemyShip(int x, int y, CollisionDetector collisionDetector, GameMap gameMap, Game game) {
        super(x, y, collisionDetector, gameMap, game);
        this.setHeading(Direction.LEFT);
    }

    @Override
    public void tick() {
        this.setColor(Color.RED);
        this.setDirection(this.getHeading());
        super.tick();
    }
}
