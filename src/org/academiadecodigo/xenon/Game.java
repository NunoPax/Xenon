package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.xenon.Handler;
import org.academiadecodigo.xenon.KeyboardListener;
import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.gameobjects.EnemyShipFactory;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;
import org.academiadecodigo.xenon.world.gameobjects.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;
import org.academiadecodigo.xenon.sound.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.sound.sampled.Clip;

public class Game implements Handler {

    private PlayerShip player;
    private World world;
    private LivesScore livesScore;
    private Sound bgm;
    private KeyboardListener listener;
    private GameMap map;
    private Text nowLoading;
    private Rectangle leftPadding;

    public Game(KeyboardListener listener) {
        this.map = new GameMap();
        this.map.init();
        this.nowLoading = new Text(700, 530, "Now Loading...");
        this.nowLoading.setFont("/res/ostrich-sans.sans-bold.ttf");
        this.nowLoading.setColor(Color.WHITE);
        this.nowLoading.draw();
        this.world = new World();
        this.player = new PlayerShip(10, GameMap.HEIGHT / 2 - 30, world);
        this.world.setPlayer(this.player);
        this.listener = listener;
        this.nowLoading.delete();
        leftPadding = new Rectangle(0, GameMap.PADDING, GameMap.PADDING, 540);
        leftPadding.setColor(Color.WHITE);
        leftPadding.fill();
    }

    public void init() {
        this.livesScore = new LivesScore(GameMap.PADDING, GameMap.PADDING, "0");
        bgm = new Sound(GameSound.BGM);
        //bgm.setLoop(Clip.LOOP_CONTINUOUSLY);
        bgm.play(true);
        this.world.add(this.player);
        listener.setHandler(this);
        this.player.show();
    }

    public void run() {
        init();

        while (this.isRunning()) {
            if (this.world.isDefeated()) {
                break;
            }

            this.tick();

            leftPadding.delete();
            leftPadding.fill();
            this.livesScore.setScore(this.player.score());

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        if (this.world.isDefeated()) {
            this.showGameWon();
        } else {
            this.showGameOver();
        }
    }

    public void showGameOver() {
        Text text = new Text(245, 280, "You lose! Press q to quit.");
        bgm.stop();
        text.setColor(Color.WHITE);
        text.setFont("/res/ostrich-sans.sans-bold.ttf");
        text.draw();
    }

    public void showGameWon() {
        Text text = new Text(245, 280, "You won! Press q to quit.");
        text.setFont("/res/ostrich-sans.sans-bold.ttf");
        text.setColor(Color.WHITE);
        text.draw();
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    public void tick() {
        this.world.tick();
    }

    @Override
    public void handlePressed(KeyboardEvent key) {
        switch (key.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(Direction.NORTH);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(Direction.SOUTH);
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
    public void handleReleased(KeyboardEvent keyEvent) {
        if (!this.player.isControllable()) {
            return;
        }
        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(null);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(null);
                break;
        }
    }
}
