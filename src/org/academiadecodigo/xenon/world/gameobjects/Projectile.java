package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;

public class Projectile extends GameObject {

    public Projectile(int x, int y, GameMap gameMap) {
        super(x, y, gameMap);
    }

    public void show() {
        //this.pic.draw();
    }

    public void hide() {
        //this.pic.delete();
    }
}
