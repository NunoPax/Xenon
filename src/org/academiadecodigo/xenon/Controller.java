/*package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import org.academiadecodigo.xenon.world.interfaces.Controllable;
import org.academiadecodigo.xenon.world.Direction;

public class Controller implements KeyboardHandler {

    private Controllable player;
    private Keyboard kbd;

    public Controller(Controllable ship) {
        this.player = ship;
        this.kbd = new Keyboard(this);
        this.init();
    }

    public void init() {
        this.addKeyPressedListener(KeyboardEvent.KEY_UP);
        this.addKeyPressedListener(KeyboardEvent.KEY_DOWN);
        this.addKeyPressedListener(KeyboardEvent.KEY_SPACE);
        this.addKeyPressedListener(KeyboardEvent.KEY_Q);

        this.addKeyReleasedListener(KeyboardEvent.KEY_UP);
        this.addKeyReleasedListener(KeyboardEvent.KEY_DOWN);
    }

    public void addKeyPressedListener(int keyEvent) {
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(keyEvent);
        e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        this.kbd.addEventListener(e);
    }

    public void addKeyReleasedListener(int keyEvent) {
        KeyboardEvent e = new KeyboardEvent();
        e.setKey(keyEvent);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        this.kbd.addEventListener(e);
    }

    @Override
    public void keyPressed(KeyboardEvent keyEvent) {

        //keyEvent.getKeyboardEventType() == KeyboardEventType.KEY_PRESSED

        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
               // this.player.setDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                if (player.isControllable()) {
                    this.player.setShooting(true);
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyEvent) {
        if (!this.player.isControllable()) {
            return;
        }

        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                //this.player.setDirection(null);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(null);
                break;
        }
    }
}
*/