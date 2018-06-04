package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.World;
import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.IGameObjectType;


enum BackgroundStarType implements IGameObjectType {

    STAR_A(6, 6, "res/Faint_Star.png"),
    STAR_B(6, 6, "res/Bright_Star.png");

    private int width;
    private int height;
    private String path;

    BackgroundStarType(int width, int height, String path) {
        this.width = width;
        this.height = height;
        this.path = path;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getPath() {
        return path;
    }
}

public class BackgroundStar extends GameObject {
    private World world;
    private BackgroundStarType type = BackgroundStarType.STAR_A;

    public BackgroundStar(BackgroundStarType type, World world) {
        super(type.getHeight(), type.getWidth(), type.getPath());
        this.world = world;
        this.type = type;

        //type = (Math.random() < 0.5) ? BackgroundStarType.STAR_A : BackgroundStarType.STAR_B;

        this.setDirection(Direction.WEST);
        this.speed = (int) (Math.random() * 2) + 1;
        int x = (int) (Math.random() * (GameMap.WIDTH - this.type.getWidth() - 11));
        int y = (int) (Math.random() * (GameMap.HEIGHT - this.type.getHeight()));
        this.reset(x, y);
    }

    @Override
    public void dispose() {
        //super.dispose();
        this.place();
    }

    public void place() {
        int x = GameMap.WIDTH - this.type.getWidth() - 20;
        int y = (int) (Math.random() * (GameMap.HEIGHT - this.type.getHeight()));
        this.reset(x, y);
    }

    public static BackgroundStar get(World world) {
        BackgroundStarType type = (Math.random() < 0.5) ? BackgroundStarType.STAR_A : BackgroundStarType.STAR_B;

        return new BackgroundStar(type, world);
    }
}
