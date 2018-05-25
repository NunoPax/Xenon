package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import org.academiadecodigo.xenon.world.Direction;
import org.academiadecodigo.xenon.world.gameobjects.Movable;

public class Controller implements KeyboardHandler {

    private Movable player;
    private Keyboard kbd;

    public Controller(Movable movable) {
        this.player = movable;
        this.kbd = new Keyboard(this);
        this.init();
    }

    public void init() {
        this.addKeyPressedListener(KeyboardEvent.KEY_LEFT);
        this.addKeyPressedListener(KeyboardEvent.KEY_RIGHT);
        this.addKeyPressedListener(KeyboardEvent.KEY_Q);
    }

    public void addKeyPressedListener(int keyEvent) {
        KeyboardEvent e = new KeyboardEvent();
	e.setKey(keyEvent);
	e.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
	this.kbd.addEventListener(e);
    }

    @Override
    public void keyPressed(KeyboardEvent keyEvent) {
        switch (keyEvent.getKey()) {
        case KeyboardEvent.KEY_LEFT:
            this.player.setDirection(Direction.LEFT);
            break;
        case KeyboardEvent.KEY_RIGHT:
            this.player.setDirection(Direction.RIGHT);
            break;
        case KeyboardEvent.KEY_Q:
            System.exit(0);
            break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyEvent) {
    }
}