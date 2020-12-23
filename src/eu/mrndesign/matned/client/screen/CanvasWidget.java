package eu.mrndesign.matned.client.screen;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import eu.mrndesign.matned.client.contract.GameContract;
import eu.mrndesign.matned.client.utils.Text;
import eu.mrndesign.matned.client.view.PlatformView;

import static eu.mrndesign.matned.client.utils.Constants.CANVAS_HEIGHT;
import static eu.mrndesign.matned.client.utils.Constants.CANVAS_WIDTH;

public class CanvasWidget extends Composite implements CanvasScreen{

    private GameContract.View view;
    private Canvas canvas;
    private Context2d context;

    public CanvasWidget() {
        createCanvas();
        view = new PlatformView(context);
        context = canvas.getContext2d();

    }

    @Override
    public void run() {
        view.currentSituation();
    }


    private Canvas createCanvas() {
        canvas = Canvas.createIfSupported();

        if (canvas == null) {
            FlowPanel flowPanel = new FlowPanel();
            flowPanel.add(new HTML(Text.HTML_5_CANVAS_ELEMENT));
            initWidget(flowPanel);
        }
        canvas.setStyleName("canvasExample");     // *** must match the div tag in CanvasExample.html ***
        canvas.setWidth(CANVAS_WIDTH + "px");
        canvas.setCoordinateSpaceWidth(CANVAS_WIDTH);
        canvas.setHeight(CANVAS_HEIGHT + "px");
        canvas.setCoordinateSpaceHeight(CANVAS_HEIGHT);
        return canvas;
    }
}
