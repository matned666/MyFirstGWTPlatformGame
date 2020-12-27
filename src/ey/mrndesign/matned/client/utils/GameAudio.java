package ey.mrndesign.matned.client.utils;

import com.google.gwt.media.client.Audio;

import static ey.mrndesign.matned.client.utils.Sounds.*;

public class GameAudio {

    public static void stepSound(){
        sound(STEP_SOUND);
    }

    public static void deathSound(){
        sound(SPLASH_SOUND);
    }

    public static void menuClickSound(){
        sound(MOUSE_CLICK_SOUND);
    }

    public static void eatSound(){
        sound(EAT_SOUND);
    }

     public static void eatPoisonSound(){
        sound(POISONED_SOUND);
    }

    private static void sound(String sound) {
        Audio makeAudio;
        makeAudio = Audio.createIfSupported();
        makeAudio.setSrc("snd/"+sound);
        makeAudio.play();
    }

}
