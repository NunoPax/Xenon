package org.academiadecodigo.xenon.world;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Clip clip;
    private URL soundURL;

    public Sound(String path) {
        initClip("/sound/backgroundmusic.wav");
    }

    /**
     * Plays the clip from the point it was stopped or from waitToStart if passed with the fromStart argument false or true
     *
     * @param fromStart should be true if want to replay the sound from the waitToStart or false otherwise
     */
    public void play(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {

        clip.stop();
    }

    public void close() {

        clip.close();
    }

    public void setLoop(int times) {
        clip.loop(times);
    }

    public void reOpen() {

        AudioInputStream inputStream = null;

        try {

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(inputStream);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initClip(String path) {

        soundURL = Sound.class.getResource(path); //if loading from jar
        AudioInputStream inputStream = null;

        try {

            if (soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intellij
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Clip getClip() {
        return clip;
    }
}