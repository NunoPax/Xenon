package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.Handler;
import org.academiadecodigo.xenon.KeyboardListener;
import org.academiadecodigo.xenon.world.Direction;

public class MainMenu implements Handler{

    private Picture logo;
    private Picture start;
    private Picture exit;
    private Picture pointer;
    private Direction pointerPos = Direction.WEST;
    private Game game;
    private KeyboardListener listener;
    private volatile boolean started;
    boolean showPointer = true;

    public MainMenu(Game game, KeyboardListener listener) {
        //this.logo = new Picture(230, 40, "res/StarPop.png");
        //this.start = new Picture(280, 375, "res/bStart.png");
        //this.exit = new Picture(555, 375, "res/bExit.png");
        //this.pointer = new Picture(270, 402, "res/Pointer.png");
        this.logo = new Picture(230, 80, "/res/StarPop.png");
        this.start = new Picture(280, 415, "/res/bStart.png");
        this.exit = new Picture(555, 415, "/res/bExit.png");
        this.pointer = new Picture(270, 442, "/res/Pointer.png");
        this.listener = listener;
        this.game = game;
        started = false;
    }

    public void drawMenu() {
        this.logo.draw();
        this.start.draw();
        this.exit.draw();
        this.pointer.draw();
    }

    public void waitToStart() {

        while (!started) { }

        hide();

        listener.setHandler(game);
        game.run();
    }

    public void start() {
        started = true;
    }

    public void hide() {
        this.logo.delete();
        this.start.delete();
        this.exit.delete();
        this.pointer.delete();
    }

    @Override
    public void handlePressed(KeyboardEvent key) {

        switch (key.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (showPointer) {
                    pointerPos = Direction.WEST;
                    this.pointer.delete();
                    pointer = new Picture(270, 442, "/res/Pointer.png");
                    pointer.draw();}
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (showPointer) {
                    pointerPos = Direction.EAST;
                    this.pointer.delete();
                    pointer = new Picture(545, 442, "/res/Pointer.png");
                    pointer.draw();}
                break;
            case KeyboardEvent.KEY_SPACE:
                if (this.pointerPos == Direction.WEST) {
                    showPointer = false;
                    start();
                } else {
                    System.exit(0);
                }
                break;
        }
    }

    @Override
    public void handleReleased(KeyboardEvent keyEvent) { }
}
