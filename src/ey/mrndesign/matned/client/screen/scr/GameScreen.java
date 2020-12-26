package ey.mrndesign.matned.client.screen.scr;

import ey.mrndesign.matned.client.contract.gamescreen.GameContract;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.screen.ScreenInterface;
import ey.mrndesign.matned.client.screen.ScreenManagerInterface;
import ey.mrndesign.matned.client.view.gamescreen.PlatformView;

public class GameScreen implements ScreenInterface {

    private GameContract.View view;

    public GameScreen(ScreenManagerInterface listener, CanvasScreen canvas) {
        view = new PlatformView(listener, canvas);
    }

    @Override
    public void currentSituation() {
        view.currentSituation();
    }


}
