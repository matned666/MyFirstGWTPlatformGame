package ey.mrndesign.matned.client.model;

import ey.mrndesign.matned.client.contract.gamescreen.Direction;

public interface Game {


    Direction moveHeroTo(double environmentX, double environmentY, double mouseX, double mouseY);

    Direction turnTo(double environmentX, double environmentY, double mouseX, double mouseY);
}
