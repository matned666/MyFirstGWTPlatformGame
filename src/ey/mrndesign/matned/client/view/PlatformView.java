package ey.mrndesign.matned.client.view;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import ey.mrndesign.matned.client.contract.GameContract;
import ey.mrndesign.matned.client.contract.MoveType;
import ey.mrndesign.matned.client.contract.Direction;
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
    private int heroPosX;
    private int heroPosY;
    private MoveType currentAction;
    private Direction currentDirection;
    private List<ViewEnvironment> environment;
    private ViewEnvironment hero;
    private CanvasScreen screen;

    public PlatformView(CanvasScreen screen, Context2d context) {
        this.screen = screen;
        this.context = context;
        this.presenter = new PlatformPresenter();
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        heroPosX = Constants.DEFAULT_HERO_START_POS_X;
        heroPosY = Constants.DEFAULT_HERO_START_POS_Y;
        environment = new LinkedList<>();
        currentAction = MoveType.STAND;
        currentDirection = Direction.RIGHT;
        hero = new Environment(HeroView.image(currentAction,currentDirection), heroPosX, heroPosY, Constants.HERO_WIDTH, Constants.HERO_HEIGHT);
        environment.add(hero);
        addKeyListeners();
    }

    @Override
    public void currentSituation() {
        paintOnCanva(backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        for (ViewEnvironment el: environment){
            paintOnCanva(el.getImage(), el.getxPos(), el.getyPos(), el.getxSize(), el.getySize());
        }
    }

    @Override
    public void onStand(Direction side) {

    }

    @Override
    public void onMove(Direction side) {

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
        screen.getCanva().addKeyDownHandler(key ->{
            if (key.isUpArrow()) presenter.action(MoveType.RUN, Direction.UP);
            else if (key.isUpArrow() && key.isRightArrow()) presenter.action(MoveType.RUN, Direction.UP_RIGHT);
            else if (key.isRightArrow()) presenter.action(MoveType.RUN, Direction.RIGHT);
            else if (key.isRightArrow() && key.isDownArrow()) presenter.action(MoveType.RUN, Direction.RIGHT_DOWN);
            else if (key.isDownArrow()) presenter.action(MoveType.RUN, Direction.DOWN);
            else if (key.isDownArrow() && key.isLeftArrow()) presenter.action(MoveType.RUN, Direction.DOWN_LEFT);
            else if (key.isLeftArrow()) presenter.action(MoveType.RUN, Direction.LEFT);
            else if (key.isLeftArrow() && key.isUpArrow()) presenter.action(MoveType.RUN, Direction.LEFT_UP);
        });
     }

    private void paintOnCanva(String image, int posx, int posy, int sizex, int sizey) {
        ImageElement img = ImageElement.as(new Image(Constants.IMG_FOLDER + image).getElement());
        context.drawImage(img, posx, posy, sizex, sizey);
    }

}
