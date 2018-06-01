package org.academiadecodigo.xenon;

//import org.academiadecodigo.xenon.controller.KeyboardListener;

public class Main {

    public static void main(String [] args) {
        KeyboardListener listener = new KeyboardListener();
        Game game = new Game(listener);
        MainMenu mainMenu = new MainMenu(game, listener);

        listener.setHandler(mainMenu);
        listener.init();
        mainMenu.drawMenu();
        mainMenu.waitToStart();
    }
}
