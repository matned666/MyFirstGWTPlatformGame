package ey.mrndesign.matned.client.view;

import com.google.gwt.user.client.Timer;

/**
 * Prosty singleton kolekcjonujący dane dla całego programu.
 * Dzięki temu mam do nich bezpośredni dostęp z każdej klasy.
 */

public class TimeWrapper {

    private static TimeWrapper instance;

    public static TimeWrapper getInstance() {
        if (instance == null) {
            synchronized (TimeWrapper.class) {
                if (instance == null) {
                    instance = new TimeWrapper();
                }
            }
        }
        return instance;
    }

    private long frameNo;

    private TimeWrapper() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
        resetFrame();
    }


    public void resetFrame(){
        frameNo = 0;
    }

    public void nextFrame(){
        frameNo++;
    }

    public long getFrameNo() {
        return frameNo;
    }


}

