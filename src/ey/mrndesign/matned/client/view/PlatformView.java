package ey.mrndesign.matned.client.view;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.ui.Image;
import ey.mrndesign.matned.client.contract.GameContract;
import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.presenter.PlatformPresenter;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.utils.Constants;
import ey.mrndesign.matned.client.utils.Images;

import java.util.LinkedList;
import java.util.List;

public class PlatformView implements GameContract.View {

    private Context2d context;
    private GameContract.Presenter presenter;
    private String backgroundImage;
    private double heroPosX;
    private double heroPosY;
    private String heroImage;
    private double mouseX;
    private double mouseY;
    private MoveType currentAction;
    private Direction currentDirection;
    private List<ViewEnvironment> environment;
    private ViewEnvironment hero;
    private CanvasScreen screen;

    public PlatformView(CanvasScreen screen) {
        this.screen = screen;
        this.context = screen.getCanva().getContext2d();
        this.presenter = new PlatformPresenter(this);
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        heroPosX = Constants.DEFAULT_HERO_START_POS_X;
        heroPosY = Constants.DEFAULT_HERO_START_POS_Y;
        environment = new LinkedList<>();
        currentAction = MoveType.STAND;
        currentDirection = Direction.UP;
        hero = new Environment(heroImage , heroPosX, heroPosY, Constants.HERO_WIDTH, Constants.HERO_HEIGHT);
        environment.add(hero);
        addKeyListeners();
    }

    @Override
    public void currentSituation() {
        paintOnCanva(backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        for (ViewEnvironment el: environment){
            paintOnCanva(el.getImage(), el.getxPos(), el.getyPos(), el.getxSize(), el.getySize());
        }
        context.strokeText("X: "+ MouseListener.getInstance().getMouseX(), 12, 20 +10);
        context.strokeText("Y: "+ MouseListener.getInstance().getMouseY(), 12, 20 +20);
        context.strokeText("Frame: "+ TimeWrapper.getInstance().getFrameNo(), 12, 20 +30);

    }

    @Override
    public void onStand(Direction side) {
       hero.setImage(HeroView.image(MoveType.STAND,side));
    }

    @Override
    public void onMove(Direction side) {
        heroImage = HeroView.image(MoveType.RUN,side);
        heroPosX = side.moveX(heroPosX);
        heroPosY = side.moveY(heroPosY);
    }

    @Override
    public void onJump(Direction side) {

    }

    @Override
    public void onShoot(Direction side) {

    }

    @Override
    public void onLooseHealth(Direction side) {

    }

    @Override
    public void uponDeath(Direction side) {

    }

    @Override
    public void uponLevelWin() {

    }

    private void addKeyListeners(){
        screen.getCanva().addMouseMoveHandler(this::mouseListen);
        screen.getCanva().addMouseDownHandler(mouse -> presenter.action(MoveType.RUN, mouseX, mouseY));
     }

    private void mouseListen(MouseMoveEvent mouse) {
        mouseX = mouse.getRelativeX(screen.getCanva().getElement());
        mouseY = mouse.getRelativeY(screen.getCanva().getElement());
        MouseListener.getInstance().setMouseX(mouseX);
        MouseListener.getInstance().setMouseY(mouseY);
        presenter.action(MoveType.STAND, mouseX, mouseY);
    }

    private void paintOnCanva(String image, double posx, double posy, double sizex, double sizey) {
        ImageElement img = ImageElement.as(new Image(Constants.IMG_FOLDER + image).getElement());
        context.drawImage(img, posx, posy, sizex, sizey);
    }


}
