package ey.mrndesign.matned.client.view.gamescreen;

import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.contract.gamescreen.Direction;

public class HeroView {

    public static String image(MoveType action, Direction direction, String prefix) {
        switch (action) {
            case STAND:
            case RUN: {
                return "h-"+prefix+"-stand" + direction.imgMark() + ".png";
            } default: {
                return "h-r-stand1.png";
            }
        }
    }
}