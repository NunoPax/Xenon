package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameMap {
    public static final int PADDING = 10;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    private Picture screen;

    public GameMap() {
        this.screen = createNewScreen();
        this.init();
    }

    private void init() {
        this.screen.draw();
    }

    private Picture createNewScreen() {
        return new Picture(
                GameMap.PADDING,
                GameMap.PADDING,
                "res/background.png"
        );
    }

    public boolean isInBounds(int x, int y, int width, int height) {
        return 0 <= x && x <= GameMap.WIDTH - width
            && 0 <= y && y <= GameMap.HEIGHT - height;
    }
}
