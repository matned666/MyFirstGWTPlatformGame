package ey.mrndesign.matned.client.view.gamescreen;

import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.contract.gamescreen.Direction;

public class HeroView {

//    changes hero image according to the direction and action
    public static String image(MoveType action, Direction direction, String prefix) {
        switch (action) {
            case STAND:
            case RUN: {
                return "h-" + prefix + "-stand" + direction.imgMark() + ".png";
            }
            case DEAD: {
                return "dead" + direction.imgMark() + ".png";
            }
            default: {
                return "h-r-stand1.png";
            }
        }
    }
}
