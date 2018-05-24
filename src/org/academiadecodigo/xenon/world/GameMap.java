package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameMap {
    private final int PADDING = 10;

    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;

    private Rectangle screen;

    public GameMap() {
        this.screen = createNewScreen();
        this.init();
    }

    private void init() {
        this.screen.draw();
    }

    private Rectangle createNewScreen() {
        return new Rectangle(
                this.PADDING,
                this.PADDING,
                GameMap.WIDTH,
                GameMap.HEIGHT
        );
    }

    public boolean isInBounds(int x, int y, int width, int height) {
        return 0 <= x && x <= GameMap.WIDTH - width
                && 0 <= y && y <= GameMap.HEIGHT - height;
    }
}
