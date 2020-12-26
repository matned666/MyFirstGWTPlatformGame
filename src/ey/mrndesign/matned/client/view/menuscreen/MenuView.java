package ey.mrndesign.matned.client.view.menuscreen;

import com.google.gwt.canvas.dom.client.Context2d;
import ey.mrndesign.matned.client.contract.menuscreen.MenuContract;
import ey.mrndesign.matned.client.presenter.MenuPresenter;
import ey.mrndesign.matned.client.screen.CanvasScreen;
import ey.mrndesign.matned.client.utils.Constants;
import ey.mrndesign.matned.client.utils.Images;
import ey.mrndesign.matned.client.view.Paint;
import ey.mrndesign.matned.client.view.gamescreen.ViewEnvironment;

import java.util.LinkedList;
import java.util.List;

import static ey.mrndesign.matned.client.view.Paint.standardView;

public class MenuView implements MenuContract.View {

    private CanvasScreen screen;
    private Context2d context;
    private MenuContract.Presenter presenter;
    private String backgroundImage;
    private List<ViewEnvironment> environment;


    public MenuView(CanvasScreen screen) {
        this.screen = screen;
        this.context = screen.getCanva().getContext2d();
        this.presenter = new MenuPresenter(this);
        this.backgroundImage = Images.BACKGROUND_IMAGE;
        environment = new LinkedList<>();
    }

    @Override
    public void currentSituation() {
        Paint.onCanva(context, backgroundImage, 0, 0, Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        standardView(environment, context);
    }


    @Override
    public void onStartGame() {

    }
}
