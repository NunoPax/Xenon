package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class LivesScore {

    private Text text;
    private int score;
    private int y;
    private int x;
    //private String text;

    public LivesScore (int x, int y, String scr){
        this.y = y;
        this.x = x;
        this.text = new Text(x, y, scr);
        this.text.setFont("/res/ostrich-sans.sans-bold.ttf");
        this.text.setColor(Color.WHITE);
        this.text.draw();
    }

    public void setText(String score){
        this.text.setText(score);
    }

    public void setScore(int score) {
        this.text.setText("Score: " + score);
    }

    public String toString() {
        return this.text.toString();
    }
}
