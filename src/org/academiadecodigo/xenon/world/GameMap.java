package org.academiadecodigo.xenon.world;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameMap {
    public static final int PADDING = 40;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    private Picture screen;

    public GameMap() {
    }

    public void init() {
        this.screen = createNewScreen();
        this.screen.draw();
    }

    private Picture createNewScreen() {
        // hack to prevent game screen from growing...
        Rectangle rightPadding = new Rectangle(WIDTH + PADDING, PADDING, PADDING, PADDING / 2);
        rightPadding.setColor(Color.WHITE);
        rightPadding.draw();
        Rectangle bottomPadding = new Rectangle(PADDING, PADDING + HEIGHT, PADDING / 2, PADDING);
        bottomPadding.setColor(Color.WHITE);
        bottomPadding.draw();

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
