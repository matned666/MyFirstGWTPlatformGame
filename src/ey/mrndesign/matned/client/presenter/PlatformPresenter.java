package ey.mrndesign.matned.client.presenter;

import ey.mrndesign.matned.client.contract.gamescreen.GameContract;
import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.model.Game;
import ey.mrndesign.matned.client.model.GameCore;
import ey.mrndesign.matned.client.model.MouseListener;

public class PlatformPresenter implements GameContract.Presenter {

    private Game game;
    private GameContract.View view;

    public PlatformPresenter(GameContract.View view) {
        this.view = view;
        this.game = new GameCore();

    }

    @Override
    public void action(MoveType action,double eX, double eY) {
        double mouseX = MouseListener.getInstance().getMouseX();
        double mouseY = MouseListener.getInstance().getMouseY();
        switch (action){
            case RUN:{
                view.onMove(game.moveHeroTo(eX, eY, mouseX, mouseY));
                break;
            }
            case STAND:{
                view.onStand(game.turnTo(eX, eY, mouseX, mouseY));
                break;
            }
            case DEAD:{
                view.onDeath();
                break;
            }

        }
    }


}
