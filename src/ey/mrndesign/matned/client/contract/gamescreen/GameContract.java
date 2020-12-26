package ey.mrndesign.matned.client.contract.gamescreen;

public class GameContract {

    public interface View {

        void currentSituation();

        void onStand(Direction side);

        void onMove(Direction side);

    }

    public interface Presenter {

        void action(MoveType action, double ex, double ey, double mx, double my);

    }

}
