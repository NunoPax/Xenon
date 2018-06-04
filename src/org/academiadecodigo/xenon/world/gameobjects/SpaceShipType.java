package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.IGameObjectType;

public enum SpaceShipType implements IGameObjectType {

    PLAYER(57, 61, "res/playerShip.png"),
    ENEMY_A(60, 70, "res/enemyShip.png"),
    ENEMY_B(70, 80, "res/medfighter.png"),
    ENEMY_C(60, 99, "res/enemyC.png"),
    ENEMY_D(90, 57, "res/enemyD.png");

    private int width;
    private int height;
    private String path;

    SpaceShipType(int width, int height, String path) {
        this.width = width;
        this.height = height;
        this.path = path;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getPath() {
        return path;
    }

    public static SpaceShipType random() {
        SpaceShipType[] types = SpaceShipType.values();
        return types[(int) (Math.random() * types.length - 1) + 1];
    }
}
