package ey.mrndesign.matned.client.view.menuscreen;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import ey.mrndesign.matned.client.contract.menuscreen.MenuAction;
import ey.mrndesign.matned.client.contract.menuscreen.MenuContract;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.presenter.MenuPresenter;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.screen.ScreenInterface;
import ey.mrndesign.matned.client.screen.ScreenManagerInterface;
import ey.mrndesign.matned.client.screen.ScreenType;
import ey.mrndesign.matned.client.screen.scr.MenuScreen;
import ey.mrndesign.matned.client.utils.Constants;
import ey.mrndesign.matned.client.utils.GameAudio;
import ey.mrndesign.matned.client.utils.Images;
import ey.mrndesign.matned.client.view.Environment;
import ey.mrndesign.matned.client.view.Paint;
import ey.mrndesign.matned.client.view.ViewEnvironment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ey.mrndesign.matned.client.utils.Constants.*;
import static ey.mrndesign.matned.client.utils.Images.*;
import static ey.mrndesign.matned.client.view.Paint.standardView;

public class MenuView implements MenuContract.View {

    private ScreenManagerInterface listener;
    private CanvasScreen screen;
    private Context2d context;
    private MenuContract.Presenter presenter;
    private String backgroundImage;
    private List<ViewEnvironment> environment;
    private ViewEnvironment startGameButton;
    private String startGameButtonImage;
    private List<HandlerRegistration> handlers;


    public MenuView(ScreenManagerInterface listener, CanvasScreen screen) {
        this.listener = listener;
        this.screen = screen;
        init();
    }

    private void init() {
        this.context = screen.getCanva().getContext2d();
        this.presenter = new MenuPresenter(this);
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        environment = new LinkedList<>();
        menuButtons();
        addKeyListeners();
    }

    private void menuButtons() {
        startGameButtonImage = START_GAME_BUTTON;
        startGameButton = new Environment(startGameButtonImage,MENU_START_GAME_BUTTON_X, MENU_START_GAME_BUTTON_Y, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
        environment.add(startGameButton);
    }

    @Override
    public void currentSituation() {
        Paint.onCanva(context, backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        standardView(environment, context);
    }

    @Override
    public void onStartGame() {
        listener.setView(ScreenType.GAME);
    }

    private void addKeyListeners() {
        handlers = new LinkedList<>();
        handlers.add(screen.getCanva().addMouseMoveHandler(this::mouseListen));
        handlers.add(screen.getCanva().addMouseDownHandler(mouse -> {
            if (startGameButton.isMouseOn()){
                startGameButton.setImage(START_GAME_BUTTON_CLICK);
            }
        }));
        handlers.add(screen.getCanva().addMouseUpHandler(mouse -> {
            if (startGameButton.isMouseOn()){
                startGameButton.setImage(START_GAME_BUTTON);
            }
        }));
        handlers.add(screen.getCanva().addClickHandler(click -> {
            if (startGameButton.isMouseOn()){
                GameAudio.menuClickSound();
                startGameButton.setImage(START_GAME_BUTTON_CLICK);
                handlers.forEach(HandlerRegistration::removeHandler);
                presenter.onClick(MenuAction.START_GAME);

            }
        }));
    }

    private void mouseListen(MouseMoveEvent mouse) {
        double mouseX = mouse.getRelativeX(screen.getCanva().getElement());
        double mouseY = mouse.getRelativeY(screen.getCanva().getElement());
        MouseListener.getInstance().setMouseX(mouseX);
        MouseListener.getInstance().setMouseY(mouseY);
        if (startGameButton.isMouseOn()){
            startGameButton.setImage(START_GAME_BUTTON_MOUSE_ON);
        } else {
            startGameButton.setImage(START_GAME_BUTTON);
        }
    }
}
