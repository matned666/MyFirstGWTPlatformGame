package ey.mrndesign.matned.client.screen;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.*;
import ey.mrndesign.matned.client.contract.GameContract;
import ey.mrndesign.matned.client.utils.Text;
import ey.mrndesign.matned.client.view.PlatformView;
import ey.mrndesign.matned.client.view.TimeWrapper;

import static ey.mrndesign.matned.client.utils.Constants.CANVAS_HEIGHT;
import static ey.mrndesign.matned.client.utils.Constants.CANVAS_WIDTH;

public class CanvasWidget extends Composite implements CanvasScreen{

    private GameContract.View view;
    private Canvas canvas;

    public CanvasWidget() {
        createCanvas();
        canvas = createCanvas();
        view = new PlatformView(this);
        TimeWrapper.getInstance();
        initWidget(canvas);
    }

    @Override
    public void run() {
        view.currentSituation();
        TimeWrapper.getInstance().nextFrame();
    }

    @Override
    public Canvas getCanva() {
        return canvas;
    }


    private Canvas createCanvas() {
        canvas = Canvas.createIfSupported();

        if (canvas == null) {
            FlowPanel flowPanel = new FlowPanel();
            flowPanel.add(new HTML(Text.HTML_5_CANVAS_ELEMENT));
            initWidget(flowPanel);
        }
        canvas.setStyleName("canvasExample");
        canvas.setWidth(CANVAS_WIDTH + "px");
        canvas.setCoordinateSpaceWidth((int) CANVAS_WIDTH);
        canvas.setHeight(CANVAS_HEIGHT + "px");
        canvas.setCoordinateSpaceHeight((int) CANVAS_HEIGHT);

        return canvas;
    }
}
