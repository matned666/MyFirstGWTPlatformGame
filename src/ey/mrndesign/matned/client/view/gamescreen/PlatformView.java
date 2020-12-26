package ey.mrndesign.matned.client.view.gamescreen;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.*;
import ey.mrndesign.matned.client.contract.gamescreen.GameContract;
import ey.mrndesign.matned.client.contract.gamescreen.MoveType;
import ey.mrndesign.matned.client.contract.gamescreen.Direction;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.presenter.PlatformPresenter;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.utils.Constants;
import ey.mrndesign.matned.client.utils.Images;
import ey.mrndesign.matned.client.view.Paint;

import java.util.LinkedList;
import java.util.List;

import static ey.mrndesign.matned.client.utils.Constants.DEFAULT_HERO_START_POS_X;
import static ey.mrndesign.matned.client.utils.Constants.DEFAULT_HERO_START_POS_Y;
import static ey.mrndesign.matned.client.utils.Images.START_HERO_IMAGE;
import static ey.mrndesign.matned.client.view.Paint.standardView;

public class PlatformView implements GameContract.View {

    private CanvasScreen screen;
    private Context2d context;
    private GameContract.Presenter presenter;
    private String backgroundImage;
    private double mouseX;
    private double mouseY;
    private List<ViewEnvironment> environment;
    private ViewEnvironment hero;
    boolean mouseDown;

    public PlatformView(CanvasScreen screen) {
        this.screen = screen;
        this.context = screen.getCanva().getContext2d();
        this.presenter = new PlatformPresenter(this);
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        environment = new LinkedList<>();
        hero = new Environment(START_HERO_IMAGE, DEFAULT_HERO_START_POS_X, DEFAULT_HERO_START_POS_Y, Constants.HERO_WIDTH, Constants.HERO_HEIGHT);
        environment.add(hero);
        mouseDown = false;
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
    }

    @Override
    public void onMove(Direction side) {
        hero.setImage(HeroView.image(MoveType.STAND, side, hero.getPrefix()));
        for (int i = 0; i < 2; i++) {
            hero.setxPos(side.moveX(hero.getxPos()));
            hero.setyPos(side.moveY(hero.getyPos()));
        }
        hero.setStep();    }

    private void addKeyListeners() {
        screen.getCanva().addMouseMoveHandler(this::mouseListen);
        screen.getCanva().addMouseDownHandler(mouse -> mouseDown = true);
        screen.getCanva().addMouseUpHandler(mouse -> mouseDown = false);
    }

    private void onMouseDown() {
        presenter.action(MoveType.RUN, hero.getxPos(), hero.getyPos(), mouseX, mouseY);
    }

    private void mouseListen(MouseMoveEvent mouse) {
        mouseX = mouse.getRelativeX(screen.getCanva().getElement());
        mouseY = mouse.getRelativeY(screen.getCanva().getElement());
        MouseListener.getInstance().setMouseX(mouseX);
        MouseListener.getInstance().setMouseY(mouseY);
        presenter.action(MoveType.STAND, hero.getxPos(), hero.getyPos(), mouseX, mouseY);
    }



}
