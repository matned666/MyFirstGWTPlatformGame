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

//    on start game we have menu
    @Override
    public void start() {
        screenType = ScreenType.MENU;
        initializeScreen();
    }

//    initializes a screen according to a screen type
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


//    this methos is refreshed each frame
    @Override
    public void currentSituation() {
                screen.currentSituation();
    }

//    sets screenType to be changed in initializeScreen() method
    @Override
    public void setView(ScreenType screen) {
        this.screenType = screen;
        initializeScreen();
    }


}
