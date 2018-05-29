package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;

public class LivesScore {

    private int score;
    private int y;
    private int x;
    private String text;

    public LivesScore (int y, int x, String scr){
        this.y = y;
        this.x = x;
        this.text = scr;
    }

    public void setText(String scor){



    }
    public String toString() {
        return text;
    }
}


