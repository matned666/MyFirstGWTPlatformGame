package ey.mrndesign.matned.client.model;

import ey.mrndesign.matned.client.contract.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameCoreTest {

//    DEFAULT_HERO_START_POS_X = 900;
//    DEFAULT_HERO_START_POS_Y = 100;

    @Test
    void degreeTestUp(){
        ey.mrndesign.matned.client.model.GameCore core = new ey.mrndesign.matned.client.model.GameCore();
        assertEquals(Direction.UP, core.turnTo(900, 50));
    }

    @Test
    void degreeTestLeft(){
        ey.mrndesign.matned.client.model.GameCore core = new ey.mrndesign.matned.client.model.GameCore();
        assertEquals(Direction.RIGHT, core.turnTo(1000, 100));
    }


    @Test
    void degreeTestUp2(){
        ey.mrndesign.matned.client.model.GameCore core = new ey.mrndesign.matned.client.model.GameCore();
        assertEquals(Direction.UP, core.turnTo(921, 38));
    }


    @Test
    void degreeTestLeftDown(){
        GameCore core = new GameCore();
        assertEquals(Direction.DOWN_LEFT, core.turnTo(850, 153));
    }

    @Test
    void angleTest(){
        GameCore core = new GameCore();
        assertEquals(Math.toRadians(45), core.angle(0,0,50,50));
    }




}
