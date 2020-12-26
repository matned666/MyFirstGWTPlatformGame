package ey.mrndesign.matned.client.screen.scr;

import ey.mrndesign.matned.client.contract.menuscreen.MenuContract;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.screen.ScreenInterface;
import ey.mrndesign.matned.client.screen.ScreenManagerInterface;
import ey.mrndesign.matned.client.view.menuscreen.MenuView;

public class MenuScreen implements ScreenInterface {

    private MenuContract.View view;

    public MenuScreen(ScreenManagerInterface listener, CanvasScreen canvas) {
        view = new MenuView(listener, canvas);
    }

    @Override
    public void currentSituation() {
        view.currentSituation();
    }
}
