package org.academiadecodigo.xenon.controller;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public interface Handler {

    void handlePressed(KeyboardEvent key);
    void handleReleased(KeyboardEvent key);
}