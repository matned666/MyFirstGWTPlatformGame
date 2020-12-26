package ey.mrndesign.matned.client.screen;

import ey.mrndesign.matned.client.contract.menuscreen.MenuAction;

public interface ScreenManagerInterface {

    void start();
    void initializeScreen();
    void currentSituation();
    void setView(ScreenType screen);
}
