package org.academiadecodigo.xenon.Menus;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.xenon.Controller;
import org.academiadecodigo.xenon.Game;

public class MainMenu {
    //public static final int PADDING = 10;

    //private Picture screen;
    private Picture start;
    private Picture exit;
    public Picture pointer;
    private Game game;

    public MainMenu(Game game) {
        this.start = new Picture(980, 305, "res/bStart.png");
        this.pointer = new Picture(970, 332, "res/Pointer.png");  // 970  437
        this.exit = new Picture(980, 410, "res/bExit.png");
        MController controller = new MController(this.pointer, this);
        this.init();
        this.game = game;
    }

    public void init() {
        this.start.draw();
        this.exit.draw();
        this.pointer.draw();
    }

    public void Start() {
        game.run();
    }
}