package eu.mrndesign.matned.client.view;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.contract.GameContract;
import eu.mrndesign.matned.client.presenter.PlatformPresenter;
import eu.mrndesign.matned.client.utils.Constants;
import eu.mrndesign.matned.client.utils.Images;

import java.util.LinkedList;
import java.util.List;

public class PlatformView implements GameContract.View {

    private Context2d context;
    private GameContract.Presenter presenter;
    private String backgroundImage;
    private int heroPosX;
    private int heroPosY;
    private GameContract.MoveType currentAction;
    private GameContract.Side currentDirection;
    private List<ViewEnvironment> environment;
    private ViewEnvironment hero;

    public PlatformView(Context2d context) {
        this.context = context;
        this.presenter = new PlatformPresenter();
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        heroPosX = Constants.DEFAULT_HERO_START_POS_X;
        heroPosY = Constants.DEFAULT_HERO_START_POS_Y;
        environment = new LinkedList<>();
        currentAction = GameContract.MoveType.STAND;
        currentDirection = GameContract.Side.RIGHT;
        hero = new Environment(HeroView.image(currentAction,currentDirection), heroPosX, heroPosY, Constants.HERO_WIDTH, Constants.HERO_HEIGHT);
        environment.add(hero);
    }

    @Override
    public void currentSituation() {
        paintOnCanva(backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        for (ViewEnvironment el: environment){
            paintOnCanva(el.getImage(), el.getxPos(), el.getyPos(), el.getxSize(), el.getySize());
        }
    }

    @Override
    public void onStand() {

    }

    @Override
    public void onMove() {

    }

    @Override
    public void onJump() {

    }

    @Override
    public void onShoot() {

    }

    @Override
    public void onLooseHealth() {

    }

    @Override
    public void uponDeath() {

    }

    @Override
    public void uponLevelWin() {

    }

    private void addKeyListeners(){
//  TODO
    }

    private void paintOnCanva(String image, int posx, int posy, int sizex, int sizey) {
        ImageElement img = ImageElement.as(new Image(Constants.IMG_FOLDER + image).getElement());
        context.drawImage(img, posx, posy, sizex, sizey);
    }

}
