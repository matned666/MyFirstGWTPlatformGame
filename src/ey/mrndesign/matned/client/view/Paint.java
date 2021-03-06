package ey.mrndesign.matned.client.view;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import ey.mrndesign.matned.client.model.MouseListener;
import ey.mrndesign.matned.client.utils.Constants;

import java.util.List;

public class Paint {

//    paints an image on context
    public static void onCanva(Context2d context, String image, double posx, double posy, double sizex, double sizey) {
        ImageElement img = ImageElement.as(new Image(Constants.IMG_FOLDER + image).getElement());
        context.drawImage(img, posx, posy, sizex, sizey);
    }

//    paints a main view objects of a field of game - list of environment
    public static void standardView(List<ViewEnvironment> environment, Context2d context) {
        for (ViewEnvironment el : environment) {
            Paint.onCanva(context, el.getImage(), el.getxPos(), el.getyPos(), el.getxSize(), el.getySize());
        }
        context.strokeText("X: " + MouseListener.getInstance().getMouseX(), 12, 20 + 10);
        context.strokeText("Y: " + MouseListener.getInstance().getMouseY(), 12, 20 + 20);
        context.strokeText("Frame: " + TimeWrapper.getInstance().getFrameNo(), 12, 20 + 30);
    }
}
