package org.academiadecodigo.xenon;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.World;

import javax.sound.sampled.Clip;

public class Game {

    private PlayerShip player;
    private World world;
    private LivesScore livesScore;

    public Game() {
        new GameMap();
        this.world = new World();
        this.player = new PlayerShip(10, GameMap.HEIGHT / 2 - 30, world);
        this.world.setPlayer(this.player);
        this.livesScore = new LivesScore(GameMap.WIDTH + GameMap.PADDING, GameMap.PADDING, "0");
    }

    public void init() {
        (new Sound("")).getClip().loop(Clip.LOOP_CONTINUOUSLY);
        this.world.add(this.player);
        new Controller(this.player);
    }

    public void run() {
        while (this.isRunning()) {
            this.tick();

            this.livesScore.setScore(this.player.score());

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    public void tick() {
        this.world.tick();
    }
}
