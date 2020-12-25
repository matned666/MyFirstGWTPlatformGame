package ey.mrndesign.matned.client.model;

import ey.mrndesign.matned.client.contract.Direction;
import ey.mrndesign.matned.client.model.object.Hero;
import ey.mrndesign.matned.client.model.object.Species;

import static ey.mrndesign.matned.client.utils.Constants.DEFAULT_HERO_START_POS_X;
import static ey.mrndesign.matned.client.utils.Constants.DEFAULT_HERO_START_POS_Y;

public class GameCore implements Game {

    private Species hero;
    private double heroX;
    private double heroY;
    private double heroNewX;
    private double heroNewY;
    private double angle;

    public GameCore() {
        hero = new Hero();
        heroX = DEFAULT_HERO_START_POS_X;
        heroY = DEFAULT_HERO_START_POS_Y;
        heroNewX = heroX;
        heroNewY = heroY;
        angle = 0;
    }


    @Override
    public Direction moveHeroTo(double mouseX, double mouseY) {
        Direction side = getDirection(heroX, heroY, mouseX, mouseY);
        hero.setPositionX(heroNewX);
        hero.setPositionY(heroNewY);
        return side;
    }

    @Override
    public Direction turnTo(double mouseX, double mouseY) {
        heroX = hero.getPositionX();
        heroY = hero.getPositionY();
        return getDirection(heroX, heroY, mouseX, mouseY);
    }


    private Direction getDirection(double heroX, double heroY, double mouseX, double mouseY) {
        angle = angle(heroX, heroY, mouseX, mouseY);
        if (setUpR(heroX, heroY, mouseX, mouseY)) return Direction.UP_RIGHT;
        else if (setRD(heroX, heroY, mouseX, mouseY)) return Direction.RIGHT_DOWN;
        else if (setDL(heroX, heroY, mouseX, mouseY)) return Direction.DOWN_LEFT;
        else if (setLUp(heroX, heroY, mouseX, mouseY)) return Direction.LEFT_UP;
        else if (setUp(heroX, heroY, mouseX, mouseY)) return Direction.UP;
        else if (setR(heroX, heroY, mouseX, mouseY)) return Direction.RIGHT;
        else if (setD(heroX, heroY, mouseX, mouseY)) return Direction.DOWN;
        else if (setL(heroX, heroY, mouseX, mouseY)) return Direction.LEFT;
        else return Direction.POINT;
    }

    double angle(double heroX, double heroY, double mouseX, double mouseY) {
        double a = (Math.abs(heroX - mouseX));
        double b = (Math.abs(heroY - mouseY));
        return Math.atan((b / a));
    }

    private boolean setUp(double heroX, double heroY, double mouseX, double mouseY) {
        return ((mouseY < heroY) && (mouseX == heroX || angle >= Math.toRadians(65.5)));
    }

    private boolean setUpR(double heroX, double heroY, double mouseX, double mouseY) {
        return (mouseY < heroY && mouseX > heroX) && (angle > Math.toRadians(22.5) && angle < Math.toRadians(67.5));
    }

    private boolean setR(double heroX, double heroY, double mouseX, double mouseY) {
        return ((mouseX > heroX) && (mouseY == heroY || angle <= Math.toRadians(22.5)));
    }

    private boolean setRD(double heroX, double heroY, double mouseX, double mouseY) {
        return (mouseY > heroY && mouseX > heroX) && (angle > Math.toRadians(22.5) && angle < Math.toRadians(67.5));
    }

    private boolean setD(double heroX, double heroY, double mouseX, double mouseY) {
        return ((mouseY > heroY) && (mouseX == heroX || angle >= Math.toRadians(22.5)));
    }

    private boolean setDL(double heroX, double heroY, double mouseX, double mouseY) {
        return (mouseY > heroY && mouseX < heroX) && (angle > Math.toRadians(22.5) && angle < Math.toRadians(67.5));
    }

    private boolean setL(double heroX, double heroY, double mouseX, double mouseY) {
        return ((mouseX < heroX) && (mouseY == heroY || angle <= Math.toRadians(22.5)));
    }

    private boolean setLUp(double heroX, double heroY, double mouseX, double mouseY) {
        return (mouseY < heroY && mouseX < heroX) && (angle > Math.toRadians(22.5) && angle < Math.toRadians(67.5));
    }

}
