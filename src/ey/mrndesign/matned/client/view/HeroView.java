package ey.mrndesign.matned.client.view;

import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;

public class HeroView {

    public static String image(MoveType action, Direction direction, String prefix) {
        switch (action) {
            case STAND:
            case RUN: {
                return "h-"+prefix+"-stand" + direction.imgMark() + ".png";
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
