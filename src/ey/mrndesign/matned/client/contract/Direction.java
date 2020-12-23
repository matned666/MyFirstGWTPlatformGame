package ey.mrndesign.matned.client.contract;

public enum Direction {
    UP,
    UP_RIGHT,
    RIGHT,
    RIGHT_DOWN,
    DOWN,
    DOWN_LEFT,
    LEFT,
    LEFT_UP;

    public int imgMark() {
        switch (this) {
            case UP: {
                return 1;
            }
            case UP_RIGHT: {
                return 2;
            }
            case RIGHT: {
                return 3;
            }
            case RIGHT_DOWN: {
                return 4;
            }
            case DOWN: {
                return 5;
            }
            case DOWN_LEFT: {
                return 6;
            }
            case LEFT: {
                return 7;
            }
            case LEFT_UP: {
                return 8;
            }
            default: return 0;
        }
    }
}
