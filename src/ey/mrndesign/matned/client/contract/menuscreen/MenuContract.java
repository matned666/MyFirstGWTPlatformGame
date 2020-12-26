package ey.mrndesign.matned.client.contract.menuscreen;

public class MenuContract {

    public interface View{

        void currentSituation();
        void onStartGame();

    }

    public interface Presenter{
        void onClick(MenuAction action);
    }

}
