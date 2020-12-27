package ey.mrndesign.matned.client.screen;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.*;
import ey.mrndesign.matned.client.utils.Text;
import ey.mrndesign.matned.client.view.TimeWrapper;

import static ey.mrndesign.matned.client.utils.Constants.CANVAS_HEIGHT;
import static ey.mrndesign.matned.client.utils.Constants.CANVAS_WIDTH;

public class CanvasWidget extends Composite implements CanvasScreen{

    private Canvas canvas;
    ScreenManager screenManager;

    public CanvasWidget() {
        createCanvas();
        canvas = createCanvas();
        screenManager = new ScreenManager(this);
        screenManager.start();
        initWidget(canvas);
    }

//    this frame is refreshed each frame
    @Override
    public void run() {
        screenManager.currentSituation();
        TimeWrapper.getInstance().nextFrame();
    }

    @Override
    public Canvas getCanva() {
        return canvas;
    }


//    creates main canvas
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
