package org.academiadecodigo.xenon.world.gameobjects;


//import javax.sound.sampled.Clip;

import java.net.URL;

public class Sound {

    //private Clip clip;
    //private URL soundURL;

    public Sound(String path) {
        Sound sound = new Sound("sound/starbox_-_05_-_digital_dream_azureflux_remix.mp3.wav");

        //initClip(path);
    }
}
/**
 * Plays the clip from the point it was stopped or from start if passed with the fromStart argument false or true
 *
 * @param fromStart should be true if want to replay the sound from the start or false otherwise
 */
        /*public void play(boolean fromStart) {

            if (fromStart) {
                clip.setFramePosition(0);
            }
            clip.start();





}*/
