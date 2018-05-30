package org.academiadecodigo.xenon;

import org.academiadecodigo.xenon.Menus.MController;
import org.academiadecodigo.xenon.Menus.MainMenu;

public class Main {

    public static void main(String [] args) {
        Game game = new Game();
        game.init();
        //MainMenu mainMenu = new MainMenu(game);
        //mainMenu.init();
        //game.init();
        game.run();
    }
}
