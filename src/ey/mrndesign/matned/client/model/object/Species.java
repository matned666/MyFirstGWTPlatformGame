package ey.mrndesign.matned.client.model.object;

public interface Species extends MovingObject{

    int getLives();
    void looseLife();
    boolean makeStep();

}
