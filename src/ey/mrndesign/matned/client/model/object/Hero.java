package ey.mrndesign.matned.client.model.object;

import static ey.mrndesign.matned.client.utils.Constants.*;

public class Hero implements Species{

    private double positionX;
    private double positionY;

    public Hero() {
        positionX = DEFAULT_HERO_START_POS_X;
        positionY = DEFAULT_HERO_START_POS_Y;
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
