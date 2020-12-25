package ey.mrndesign.matned.client.presenter;

import ey.mrndesign.matned.client.contract.GameContract;
import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;
import ey.mrndesign.matned.client.model.Game;
import ey.mrndesign.matned.client.model.GameCore;
import ey.mrndesign.matned.client.model.object.Hero;
import ey.mrndesign.matned.client.model.object.Species;
import ey.mrndesign.matned.client.view.ViewEnvironment;

public class PlatformPresenter implements GameContract.Presenter {

    private Game game;
    private GameContract.View view;

    public PlatformPresenter(GameContract.View view) {
        this.view = view;
        this.game = new GameCore();

    }

    @Override
    public void action(MoveType action,double eX, double eY, double mouseX, double mouseY) {
        switch (action){
            case RUN:{
                view.onMove(game.moveHeroTo(eX, eY, mouseX, mouseY));
            }
            case STAND:{
                view.onStand(game.turnTo(eX, eY, mouseX, mouseY));
            }
            case JUMP:{
                view.onJump(game.moveHeroTo(eX, eY, mouseX, mouseY));
            }
        }
    }

    @Override
    public void looseLife(Species object) {

    }


}
