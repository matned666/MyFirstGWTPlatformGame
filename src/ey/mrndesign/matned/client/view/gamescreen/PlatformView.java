package ey.mrndesign.matned.client.view.gamescreen;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import ey.mrndesign.matned.client.contract.gamescreen.GameContract;
import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.contract.gamescreen.Direction;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.presenter.PlatformPresenter;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.screen.ScreenManagerInterface;
import ey.mrndesign.matned.client.screen.ScreenType;
import ey.mrndesign.matned.client.utils.Constants;
import ey.mrndesign.matned.client.utils.GameAudio;
import ey.mrndesign.matned.client.utils.Images;
import ey.mrndesign.matned.client.view.Environment;
import ey.mrndesign.matned.client.view.Paint;
import ey.mrndesign.matned.client.view.TimeWrapper;
import ey.mrndesign.matned.client.view.ViewEnvironment;

import java.util.LinkedList;
import java.util.List;

import static ey.mrndesign.matned.client.utils.Constants.*;
import static ey.mrndesign.matned.client.utils.Images.START_HERO_IMAGE;
import static ey.mrndesign.matned.client.view.Paint.standardView;

public class PlatformView implements GameContract.View {

    //    variables
    private ScreenManagerInterface listener;
    private CanvasScreen screen;
    private Context2d context;
    private GameContract.Presenter presenter;
    private String backgroundImage;
    private List<ViewEnvironment> environment;
    private List<HandlerRegistration> handlers;
    private ViewEnvironment hero;
    private boolean mouseDown;
    private Direction currentDirection;
    private boolean isDead;
    private int points;
    private int timeLeft;
    private int randomCrumbPutTime;

    public PlatformView(ScreenManagerInterface listener, CanvasScreen screen) {
        this.listener = listener;
        this.screen = screen;
        this.context = screen.getCanva().getContext2d();
        this.presenter = new PlatformPresenter(this);
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        environment = new LinkedList<>();
        hero = new Environment(START_HERO_IMAGE, DEFAULT_HERO_START_POS_X, DEFAULT_HERO_START_POS_Y, Constants.HERO_WIDTH, Constants.HERO_HEIGHT);
        environment.add(hero);
        mouseDown = false;
        isDead = false;
        points = 0;
        timeLeft = DEFAULT_START_TIME;
        addKeyListeners();
    }

    //    method refreshed each frame
    @Override
    public void currentSituation() {
        Paint.onCanva(context, backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        if (mouseDown) onMouseDown();
        standardView(environment, context);
        context.strokeText("Points: " + points, 12, 20 + 40);
        context.strokeText("Time left: " + timeLeft, 12, 20 + 50);
        randomCrumbPutTime = (int) (Math.random() * 200 + 50);
        checkIfGotCrumbs();
        putCrumb();
        if (TimeWrapper.getInstance().getFrameNo() % 3 == 0)
            timeLeft -= 1;
        if (timeLeft == 0) {
            isDead = true;
            presenter.action(MoveType.DEAD, hero.getxPos(), hero.getyPos());
        }
    }

    //    setting image on mouse move - on from presenter
    @Override
    public void onStand(Direction side) {
        hero.setImage(HeroView.image(MoveType.STAND, side, hero.getPrefix()));
        currentDirection = side;
    }

    //    moving - on from presenter
    @Override
    public void onMove(Direction side) {
        hero.setImage(HeroView.image(MoveType.STAND, side, hero.getPrefix()));
        for (int i = 0; i < 2; i++) {
            hero.setxPos(side.moveX(hero.getxPos()));
            hero.setyPos(side.moveY(hero.getyPos()));
        }
        if (TimeWrapper.getInstance().getFrameNo() % 5 == 0) GameAudio.stepSound();
        hero.setStep();
    }
//    Death
    @Override
    public void onDeath() {
        hero.setImage(HeroView.image(MoveType.DEAD, currentDirection, hero.getPrefix()));
        GameAudio.deathSound();
    }

//    putting crumb
    @Override
    public void onCrumbPut(String image, double xPos, double yPos, double size) {
        environment.add(new Environment(image, xPos, yPos, size, size));
    }

//    eat simple crumb
    @Override
    public void onCrumbEaten(ViewEnvironment env, int points, int additionalTime) {
        this.points = points;
        this.environment.remove(env);
        this.timeLeft += additionalTime;
        GameAudio.eatSound();
    }

//    eats poisoned crumb
    @Override
    public void onPoisonedCrumbEaten(ViewEnvironment env, int additionalTime) {
        this.environment.remove(env);
        this.timeLeft += additionalTime;
        GameAudio.eatPoisonSound();
    }

    private void addKeyListeners() {
        handlers = new LinkedList<>();
        handlers.add(screen.getCanva().addMouseMoveHandler(this::mouseListen));
        handlers.add(screen.getCanva().addClickHandler(this::mouseClick));
        handlers.add(screen.getCanva().addMouseDownHandler(mouse -> mouseDown = true));
        handlers.add(screen.getCanva().addMouseUpHandler(mouse -> mouseDown = false));
    }

    private void mouseClick(ClickEvent clickEvent) {
        if (hero.isMouseOn()) {
            isDead = true;
            presenter.action(MoveType.DEAD, hero.getxPos(), hero.getyPos());
        }
        if (isDead && !hero.isMouseOn()) {
            listener.setView(ScreenType.MENU);
            isDead = false;
        }

    }


    private void onMouseDown() {
        if (!isDead) presenter.action(MoveType.RUN, hero.getxPos(), hero.getyPos());
    }


//    checks a position of mouse
    private void mouseListen(MouseMoveEvent mouse) {
        double mouseX = mouse.getRelativeX(screen.getCanva().getElement());
        double mouseY = mouse.getRelativeY(screen.getCanva().getElement());
        MouseListener.getInstance().setMouseX(mouseX);
        MouseListener.getInstance().setMouseY(mouseY);
        if (!isDead) presenter.action(MoveType.STAND, hero.getxPos(), hero.getyPos());
    }


//    check if hero touches any of the lying crumbs
    private void checkIfGotCrumbs() {
        for (int i = 1; i < environment.size(); i++) {
            if (hero.collisionWith(environment.get(i))) {
                presenter.eatCrumb(environment.get(i));
                return;
            }

        }
    }

//    putting crumb on the screen
    private void putCrumb() {
        if (TimeWrapper.getInstance().getFrameNo() % randomCrumbPutTime == 0 || TimeWrapper.getInstance().getFrameNo() == 10) {
            presenter.action(MoveType.PUT_NEW_CRUMB);
        }
    }


}
