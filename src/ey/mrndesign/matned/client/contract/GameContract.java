package ey.mrndesign.matned.client.contract;

public class GameContract {

    public interface View{

        void currentSituation();

        void onStand();
        void onMove();
        void onJump();
        void onShoot();
        void onLooseHealth();
        void uponDeath();
        void uponLevelWin();
    }

    public interface Presenter{

        void move(MoveType action, Side direction);
        void looseLife();
        void finishLevel();

    }

    public enum Side{
        LEFT,
        RIGHT
    }

    public enum MoveType{
        STAND,
        RUN,
        JUMP,
        SHOOT
    }
}
