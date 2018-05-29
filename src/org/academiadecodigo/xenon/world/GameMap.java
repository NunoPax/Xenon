package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameMap {
    public static final int PADDING = 10;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    private Picture screen;
    private Picture start;
    private Picture exit;
    private Picture pointer;

    public GameMap() {
        this.start = new Picture(1050, 305, "res/start.jpg");
        this.pointer = new Picture(1040, 330, "res/Pointer.png");
        this.screen = createNewScreen();
        this.init();
    }

    private void init() {
        this.start.draw();
        this.pointer.draw();
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
