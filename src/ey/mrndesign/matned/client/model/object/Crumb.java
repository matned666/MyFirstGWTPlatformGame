package ey.mrndesign.matned.client.model.object;

import static ey.mrndesign.matned.client.utils.Constants.*;
import static ey.mrndesign.matned.client.utils.Images.*;

public enum Crumb {
    SMALL,
    MEDIUM,
    LARGE,
    POISONED;

    public static Crumb crumbLottery(){
        int randomInt = (int) (Math.random() * 100);
        if (randomInt < 50) return SMALL;
        else if (randomInt < 80) return MEDIUM;
        else if (randomInt < 90) return LARGE;
        else return POISONED;
    }

    public static Crumb findByImage(String image) {
        switch (image) {
            case SMALL_CRUMB+PNG: return SMALL;
            case MEDIUM_CRUMB+PNG: return MEDIUM;
            case POISONEDCRUMB +PNG: return POISONED;
            default: return LARGE;
        }
    }

    public double getSize(){
        switch (this){
            case SMALL: return SMALL_CRUMB_SIZE;
            case LARGE:
            case POISONED:
                return LARGE_CRUMB_SIZE;
            default: return MEDIUM_CRUMB_SIZE;
        }
    }

    public int points() {
        switch (this){
            case SMALL: return 2;
            case LARGE: return 5;
            case POISONED: return 0;
            default: return 3;
        }
    }

    public String image(){
        switch (this){
            case SMALL: return SMALL_CRUMB+PNG;
            case LARGE: return LARGE_CRUMB+PNG;
            case POISONED: return POISONEDCRUMB+PNG;
            default: return MEDIUM_CRUMB+PNG;
        }
    }

    public int addTime() {
        switch (this){
            case SMALL: return 50;
            case LARGE: return 150;
            case POISONED: return -100;
            default: return 80;
        }    }
}
