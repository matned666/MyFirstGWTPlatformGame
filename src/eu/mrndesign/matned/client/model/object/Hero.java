package eu.mrndesign.matned.client.model.object;

import static eu.mrndesign.matned.client.utils.Constants.DEFAULT_START_LIVES;

public class Hero implements Species{

    private int lives;
    private int positionX;
    private int positionY;
    private int sizeX;
    private int sizeY;

    public Hero() {
        lives = DEFAULT_START_LIVES;
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
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
