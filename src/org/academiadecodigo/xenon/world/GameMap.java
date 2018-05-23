package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameMap {
    private final int PADDING = 10;

    private int width = 200;
    private int height = 200;

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
                this.width,
                this.height
        );
    }

    public boolean isInBounds(int x, int y) {
        return false;
    }
}
