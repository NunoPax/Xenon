package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.IGameObjectType;

public enum BossShipType implements IGameObjectType {
    BOSS_A(102, 170, "/res/6B.png"),
    BOSS_B(122, 342, "/res/12B.png"),
    BOSS_C(104, 168, "/res/13B.png");

    private int width;
    private int height;
    private String path;

    BossShipType(int width, int height, String path) {
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
        return this.height;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    public static BossShipType random() {
        BossShipType[] types = BossShipType.values();
        return types[(int) (Math.random() * types.length)];
    }
}
