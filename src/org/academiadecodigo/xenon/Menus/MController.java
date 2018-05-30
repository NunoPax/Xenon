package org.academiadecodigo.xenon.Menus;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.xenon.Game;
import org.academiadecodigo.xenon.Main;
import org.academiadecodigo.xenon.world.Direction;


public class MController implements KeyboardHandler {

    private Picture pointer;
    private Direction pointerPos = Direction.UP;
    private Keyboard mKbd;
    MainMenu mainMenu;

    public MController(Picture pointer, MainMenu mainMenu) {
        this.pointer = pointer;
        this.mKbd = new Keyboard(this);
        this.mainMenu = mainMenu;
        this.init();
    }

    public void init() {
        this.addKeyPressedListener(KeyboardEvent.KEY_W);
        this.addKeyPressedListener(KeyboardEvent.KEY_S);
        this.addKeyPressedListener(KeyboardEvent.KEY_G);
        //this.addKeyPressedListener(KeyboardEvent.KEY_Q);
        //this.addKeyPressedListener(KeyboardEvent.KEY_S);

        //this.addKeyReleasedListener(KeyboardEvent.KEY_UP);
        //this.addKeyReleasedListener(KeyboardEvent.KEY_DOWN);
    }

    public void addKeyPressedListener(int keyEvent) {
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(keyEvent);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.mKbd.addEventListener(e);
    }

    /*public void addKeyReleasedListener(int keyEvent) {
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(keyEvent);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.mKbd.addEventListener(e);
    }*/

    @Override
    public void keyPressed(KeyboardEvent keyEvent) {

        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                pointerPos = Direction.UP;
                this.pointer.delete();
                pointer = new Picture(970, 332, "res/Pointer.png");
                pointer.draw();
                break;
            case KeyboardEvent.KEY_S:
                pointerPos = Direction.DOWN;
                this.pointer.delete();
                pointer = new Picture(970, 437, "res/Pointer.png");
                pointer.draw();
                break;
            case KeyboardEvent.KEY_G:
                if (this.pointerPos == Direction.UP) {
                    mainMenu.Start();
                } else {
                    System.exit(0);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyEvent) {
    }
}