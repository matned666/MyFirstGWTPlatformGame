package ey.mrndesign.matned.client.contract;

import static ey.mrndesign.matned.client.utils.Constants.COCKROACH_SPEED;

public enum Direction {
    UP,
    UP_RIGHT,
    RIGHT,
    RIGHT_DOWN,
    DOWN,
    DOWN_LEFT,
    LEFT,
    LEFT_UP,
    POINT;

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
            default: return 1;
        }
    }

    public double moveX(double x){
        switch (this) {
            case UP_RIGHT:
            case RIGHT_DOWN: {
                return x + COCKROACH_SPEED /2;
            }
            case RIGHT: {
                return x + COCKROACH_SPEED;
            }
            case DOWN_LEFT:
            case LEFT_UP: {
                return x - COCKROACH_SPEED /2;
            }
            case LEFT: {
                return x - COCKROACH_SPEED;
            }
            default: return x;
        }
    }

    public double moveY(double y){
        switch (this) {
            case UP: {
                return  y - COCKROACH_SPEED;
            }
            case UP_RIGHT:
            case LEFT_UP: {
                return  y - (COCKROACH_SPEED / 2);
            }
            case RIGHT_DOWN:
            case DOWN_LEFT: {
                return y + COCKROACH_SPEED /2;
            }
            case DOWN: {
                return y + COCKROACH_SPEED;
            }
            default: return y;
        }
    }
}
