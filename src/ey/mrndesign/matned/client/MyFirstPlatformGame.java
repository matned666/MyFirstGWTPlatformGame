package ey.mrndesign.matned.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.screen.CanvasWidget;
import com.google.gwt.core.client.EntryPoint;

import static ey.mrndesign.matned.client.utils.Constants.PERIOD_MILLIS;

public class MyFirstPlatformGame implements EntryPoint {

    static final String canvasDivTag = "gameCanvas";

    public void onModuleLoad() {

        final Timer timer;
        CanvasScreen gameWidget = new CanvasWidget();


        timer = new Timer() {
            @Override
            public void run() {
                gameWidget.run();
            }
        };
        timer.scheduleRepeating(PERIOD_MILLIS);
        RootPanel.get(canvasDivTag).add((IsWidget) gameWidget);

    }


}