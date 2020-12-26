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

    private ScreenManagerInterface listener;
    private CanvasScreen screen;
    private Context2d context;
    private GameContract.Presenter presenter;
    private String backgroundImage;
    private List<ViewEnvironment> environment;
    private ViewEnvironment hero;
    boolean mouseDown;
    private Direction currentDirection;
    private boolean isDead;


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
        addKeyListeners();
    }

    @Override
    public void currentSituation() {
        Paint.onCanva(context, backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        if (mouseDown) onMouseDown();
        standardView(environment, context);

    }

    @Override
    public void onStand(Direction side) {
        hero.setImage(HeroView.image(MoveType.STAND, side, hero.getPrefix()));
        currentDirection = side;
    }

    @Override
    public void onMove(Direction side) {
        hero.setImage(HeroView.image(MoveType.STAND, side, hero.getPrefix()));
        for (int i = 0; i < 2; i++) {
            hero.setxPos(side.moveX(hero.getxPos()));
            hero.setyPos(side.moveY(hero.getyPos()));
        }
        if (TimeWrapper.getInstance().getFrameNo()% 5 == 0) GameAudio.stepSound();
        hero.setStep();
    }

    @Override
    public void onDeath() {
        hero.setImage(HeroView.image(MoveType.DEAD, currentDirection, hero.getPrefix()));
        GameAudio.deathSound();
    }

    private void addKeyListeners() {
        List<HandlerRegistration> handlers = new LinkedList<>();
        handlers.add(screen.getCanva().addMouseMoveHandler(this::mouseListen));
        handlers.add(screen.getCanva().addClickHandler(this::mouseClick));
        handlers.add(screen.getCanva().addMouseDownHandler(mouse -> mouseDown = true));
        handlers.add(screen.getCanva().addMouseUpHandler(mouse -> mouseDown = false));
    }

    private void mouseClick(ClickEvent clickEvent) {
        if (hero.isMouseOn()){
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

    private void mouseListen(MouseMoveEvent mouse) {
        double mouseX = mouse.getRelativeX(screen.getCanva().getElement());
        double mouseY = mouse.getRelativeY(screen.getCanva().getElement());
        MouseListener.getInstance().setMouseX(mouseX);
        MouseListener.getInstance().setMouseY(mouseY);
        if (!isDead) presenter.action(MoveType.STAND, hero.getxPos(), hero.getyPos());
    }



}
