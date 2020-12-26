package ey.mrndesign.matned.client.presenter;

import ey.mrndesign.matned.client.contract.menuscreen.MenuAction;
import ey.mrndesign.matned.client.contract.menuscreen.MenuContract;

public class MenuPresenter implements MenuContract.Presenter {

    private MenuContract.View view;

    public MenuPresenter(MenuContract.View view) {
        this.view = view;
    }

    @Override
    public void onClick(MenuAction action) {
        switch (action){
            case START_GAME: view.onStartGame();
        }
    }
}
