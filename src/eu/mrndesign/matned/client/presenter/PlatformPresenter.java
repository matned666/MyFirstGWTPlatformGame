package eu.mrndesign.matned.client.presenter;

import eu.mrndesign.matned.client.contract.GameContract;
import eu.mrndesign.matned.client.model.Game;

public class PlatformPresenter implements GameContract.Presenter {

    private Game game;

    @Override
    public void move(GameContract.MoveType action, GameContract.Side direction) {

    }

    @Override
    public void looseLife() {

    }

    @Override
    public void finishLevel() {

    }
}
