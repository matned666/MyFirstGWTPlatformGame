package ey.mrndesign.matned.client.presenter;

import ey.mrndesign.matned.client.contract.gamescreen.GameContract;
import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.model.Game;
import ey.mrndesign.matned.client.model.GameCore;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.model.object.Crumb;
import ey.mrndesign.matned.client.view.ViewEnvironment;

import static ey.mrndesign.matned.client.utils.Constants.CANVAS_HEIGHT;
import static ey.mrndesign.matned.client.utils.Constants.CANVAS_WIDTH;

public class PlatformPresenter implements GameContract.Presenter {

    private Game game;
    private GameContract.View view;

    public PlatformPresenter(GameContract.View view) {
        this.view = view;
        this.game = new GameCore();

    }

    @Override
    public void action(MoveType action) {
        if (action == MoveType.PUT_NEW_CRUMB) {
            Crumb crumb = Crumb.crumbLottery();
            double xPos = Math.random() * (CANVAS_WIDTH - crumb.getSize());
            double yPos = Math.random() * (CANVAS_HEIGHT - crumb.getSize());
            view.onCrumbPut(crumb.image(), xPos, yPos, crumb.getSize());
        }
    }

    @Override
    public void action(MoveType action,double eX, double eY) {
        double mouseX = MouseListener.getInstance().getMouseX();
        double mouseY = MouseListener.getInstance().getMouseY();
        switch (action){
            case RUN:{
                view.onMove(game.moveHeroTo(eX, eY, mouseX, mouseY));
                break;
            }
            case STAND:{
                view.onStand(game.turnTo(eX, eY, mouseX, mouseY));
                break;
            }
            case DEAD:{
                view.onDeath();
                break;
            }

        }
    }

    @Override
    public void eatCrumb(ViewEnvironment environment) {
        Crumb crumb = Crumb.findByImage(environment.getImage());
        game.addPoints(crumb);
//        game.addTime(crumb);
        assert crumb != null;
        if (crumb != Crumb.POISONED) view.onCrumbEaten(environment, game.getPoints(), crumb.addTime());
        else view.onPoisonedCrumbEaten(environment, crumb.addTime());
    }

    @Override
    public int timeLeft(int time) {
        game.addTime(time);
        return game.getTimeLeft();
    }


}
