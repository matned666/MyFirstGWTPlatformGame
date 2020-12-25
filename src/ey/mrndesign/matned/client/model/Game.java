package ey.mrndesign.matned.client.model;

import ey.mrndesign.matned.client.contract.Direction;

public interface Game {


    Direction moveHeroTo(double mouseX, double mouseY);

    Direction turnTo(double mouseX, double mouseY);
}
