package ey.mrndesign.matned.client.contract.gamescreen;

import ey.mrndesign.matned.client.view.ViewEnvironment;

public class GameContract {

    public interface View {

        void currentSituation();

        void onStand(Direction side);

        void onMove(Direction side);

        void onDeath();

        void onCrumbPut(String image, double xPos, double yPos, double size);

        void onCrumbEaten(ViewEnvironment environment, int points, int additionalTime);

        void onPoisonedCrumbEaten(ViewEnvironment environment, int addTime);
    }

    public interface Presenter {

        void action(MoveType action);
        void action(MoveType action, double ex, double ey);
        void eatCrumb(ViewEnvironment environment);
        int timeLeft(int addTime);
    }

}
