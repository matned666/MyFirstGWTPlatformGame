package ey.mrndesign.matned.client.screen;

import ey.mrndesign.matned.client.screen.scr.GameScreen;
import ey.mrndesign.matned.client.screen.scr.MenuScreen;

public class ScreenManager implements ScreenManagerInterface {

    private ScreenType screenType;
    private ScreenInterface screen;
    private CanvasScreen canvas;

    public ScreenManager(CanvasScreen canvas) {
        this.canvas = canvas;
    }

    @Override
    public void start() {
        screenType = ScreenType.MENU;
        initializeScreen();
    }

    @Override
    public void initializeScreen() {
        switch (screenType){
            case GAME:{
                screen = new GameScreen(this, canvas);
                break;
            }
            case MENU:{
                screen = new MenuScreen(this, canvas);
                break;
            }
        }
    }


    @Override
    public void currentSituation() {
                screen.currentSituation();
    }

    @Override
    public void setView(ScreenType screen) {
        this.screenType = screen;
        initializeScreen();
    }


}
