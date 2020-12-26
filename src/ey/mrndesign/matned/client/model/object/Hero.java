package ey.mrndesign.matned.client.model.object;

import static ey.mrndesign.matned.client.utils.Constants.*;

public class Hero implements Species{

    private int lives;
    private double positionX;
    private double positionY;
    private double sizeX;
    private double sizeY;
    private boolean madeStep;

    public Hero() {
        lives = DEFAULT_START_LIVES;
        positionX = DEFAULT_HERO_START_POS_X;
        positionY = DEFAULT_HERO_START_POS_Y;
        sizeX = HERO_WIDTH;
        sizeY = HERO_HEIGHT;
        madeStep = false;
    }

    @Override
    public int getLives() {
        return lives;
    }

    @Override
    public void looseLife() {
        lives--;
    }

    @Override
    public boolean makeStep() {
        madeStep = !madeStep;
        return madeStep;
    }

    @Override
    public double getSizeX() {
        return sizeX;
    }

    @Override
    public double getSizeY() {
        return sizeY;
    }

    @Override
    public double getPositionX() {
        return positionX;
    }

    @Override
    public double getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
