package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameMap {
    public static final int PADDING = 10;

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
                GameMap.PADDING,
                GameMap.PADDING,
                GameMap.WIDTH,
                GameMap.HEIGHT
        );
    }

    public boolean isInBounds(int x, int y, int width, int height) {
        return 0 <= x && x <= GameMap.WIDTH - width
            && 0 <= y && y <= GameMap.HEIGHT - height;
    }

}
