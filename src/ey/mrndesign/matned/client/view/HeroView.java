package ey.mrndesign.matned.client.view;

import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;

public class HeroView {

    public static String image(MoveType action, Direction direction) {
        switch (action) {
            case STAND: {
                return "h-r-stand" + direction.imgMark() + ".png";
            }
            case RUN: {
                return "h-r-jump1.png";
            }
            case SHOOT: {
                return "h-r-shoot1.png";
            }
            default: {
                return "h-r-stand1.png";
            }
        }
    }
}
