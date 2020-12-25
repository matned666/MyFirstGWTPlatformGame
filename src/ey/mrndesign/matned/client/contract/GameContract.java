package ey.mrndesign.matned.client.contract;

import ey.mrndesign.matned.client.model.object.Species;

public class GameContract {

    public interface View {

        void currentSituation();

        void onStand(Direction side);

        void onMove(Direction side);

        void onJump(Direction side);

        void onShoot(Direction side);

        void onLooseHealth(Direction side);

        void uponDeath(Direction side);

        void uponLevelWin();
    }

    public interface Presenter {

        void action(MoveType action, double ex, double ey, double mx, double my);

        void looseLife(Species object);

    }

}
