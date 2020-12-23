package ey.mrndesign.matned.client.view;

import ey.mrndesign.matned.client.contract.GameContract;

public class HeroView {

    public static String image(GameContract.MoveType action, GameContract.Side direction) {
        switch (action) {
            case RUN: {
                if (direction == GameContract.Side.RIGHT) return "h-r-run1.png";
                else return "h-l-run1.png";
            }
            case JUMP: {
                if (direction == GameContract.Side.RIGHT) return "h-r-jump1.png";
                else return "h-l-jump1.png";
            }
            case SHOOT: {
                if (direction == GameContract.Side.RIGHT) return "h-r-shoot1.png";
                else return "h-l-shoot1.png";
            }
            default: {
                if (direction == GameContract.Side.RIGHT) return "h-r-stand1.png";
                else return "h-l-stand1.png";            }
        }
    }
}
