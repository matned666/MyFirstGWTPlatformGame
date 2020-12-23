package ey.mrndesign.matned.client.presenter;

import ey.mrndesign.matned.client.contract.GameContract;
import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;
import ey.mrndesign.matned.client.model.Game;
import ey.mrndesign.matned.client.model.GameCore;
import ey.mrndesign.matned.client.model.object.Species;

public class PlatformPresenter implements GameContract.Presenter {

    private Game game;

    public PlatformPresenter() {
        this.game = new GameCore();
    }

    @Override
    public void action(MoveType action, Direction side) {
        switch (action){
            case RUN:{
                runAction();
            }
        }
    }

    @Override
    public void looseLife(Species object) {

    }


    private void runAction() {

    }
}
