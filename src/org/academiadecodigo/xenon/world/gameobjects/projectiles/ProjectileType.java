package org.academiadecodigo.xenon.world.gameobjects.projectiles;

public enum ProjectileType {

    STAR(22, 21, "/res/star.png"),
    CIRCLE(22, 22, "/res/enemyProjectile.png");

    private int width;
    private int height;
    private String path;


    ProjectileType(int width, int height, String path) {
        this.width = width;
        this.height = height;
        this.path = path;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPath(){
        return this.path;

    }
}
