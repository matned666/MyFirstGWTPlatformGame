package ey.mrndesign.matned.client.model;

import ey.mrndesign.matned.client.contract.gamescreen.Direction;
import ey.mrndesign.matned.client.model.object.Crumb;

public interface Game {

//    int getTimeLeft();
//
//    void addTime(int additionalTime);

    int getPoints();

    void addPoints(Crumb crumb);

    Direction moveHeroTo(double environmentX, double environmentY, double mouseX, double mouseY);

    Direction turnTo(double environmentX, double environmentY, double mouseX, double mouseY);
}
