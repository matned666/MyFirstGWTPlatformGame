package ey.mrndesign.matned.client.view;

import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;

public class HeroView {

    public static String image(MoveType action, Direction direction) {
        switch (action) {
            case RUN: {
                if (direction == Direction.RIGHT) return "h-r-run1.png";
                else return "h-l-run1.png";
            }
            case JUMP: {
                if (direction == Direction.RIGHT) return "h-r-jump1.png";
                else return "h-l-jump1.png";
            }
            case SHOOT: {
                if (direction == Direction.RIGHT) return "h-r-shoot1.png";
                else return "h-l-shoot1.png";
            }
            default: {
                if (direction == Direction.RIGHT) return "h-r-stand1.png";
                else return "h-l-stand1.png";            }
        }
    }
}
