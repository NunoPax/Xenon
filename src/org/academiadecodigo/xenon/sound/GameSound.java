package org.academiadecodigo.xenon.sound;

public enum GameSound {
    BGM("/sound/backgroundmusic.wav"),
    PLAYER_LASER("/sound/Laser_Shoot53.wav"),
    ENEMY_LASER("/sound/Laser_Shoot42.wav"),
    EXPLOSION("/sound/Explosion71.wav");

    private String path;

    GameSound(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
