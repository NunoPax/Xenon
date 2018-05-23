package org.academiadecodigo.xenon;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.CollisionDetector;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;

public class Game {

    private GameMap gameMap;
    private CollisionDetector collisionDetector;
    private PlayerShip player;

    public Game() {
        this.gameMap = new GameMap();
        this.collisionDetector = new CollisionDetector(null);
        this.player = new PlayerShip(10, 10, collisionDetector);
        this.player.show();
        Controller controller = new Controller(this.player);

    }

    public void run() {
    }
}
