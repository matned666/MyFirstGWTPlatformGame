package ey.mrndesign.matned.client.view;

public interface ViewEnvironment {

    String getPrefix();
    void setStep();
    void setxPos(double xPos);
    void setyPos(double yPos);
    String getImage();
    String setImage(String image);
    double getxPos();
    double getyPos();
    double getxSize();
    double getySize();

}
