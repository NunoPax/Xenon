package org.academiadecodigo.xenon.controller;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler{

    private Handler handler;
    private Keyboard kbd;

    public KeyboardListener() { }

    public void init() {
        this.kbd = new Keyboard(this);
        this.addKeyPressedListener(KeyboardEvent.KEY_UP);
        this.addKeyPressedListener(KeyboardEvent.KEY_DOWN);
        this.addKeyPressedListener(KeyboardEvent.KEY_SPACE);
        this.addKeyPressedListener(KeyboardEvent.KEY_LEFT);
        this.addKeyPressedListener(KeyboardEvent.KEY_RIGHT);

        this.addKeyReleasedListener(KeyboardEvent.KEY_UP);
        this.addKeyReleasedListener(KeyboardEvent.KEY_DOWN);
        this.addKeyReleasedListener(KeyboardEvent.KEY_SPACE);
        this.addKeyReleasedListener(KeyboardEvent.KEY_LEFT);
        this.addKeyReleasedListener(KeyboardEvent.KEY_RIGHT);
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
    public void keyPressed(KeyboardEvent keyboardEvent) {
        handler.handlePressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        handler.handleReleased(keyboardEvent);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}