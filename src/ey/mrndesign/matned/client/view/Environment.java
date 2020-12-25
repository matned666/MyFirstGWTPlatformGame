package ey.mrndesign.matned.client.view;

public class Environment implements ViewEnvironment{

    private String image;
    private double xPos;
    private double yPos;
    private double xSize;
    private double ySize;
    private boolean step;

    public Environment(String image, double xPos, double yPos, double xSize, double ySize) {
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        step = false;
    }

    @Override
    public String getPrefix() {
        if (step) return "s";
        else return "r";
    }

    @Override
    public void setStep() {
        step = !step;
    }

    @Override
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String setImage(String image) {
        return this.image = image;
    }

    @Override
    public double getxPos() {
        return xPos;
    }

    @Override
    public double getyPos() {
        return yPos;
    }

    @Override
    public double getxSize() {
        return xSize;
    }

    @Override
    public double getySize() {
        return ySize;
    }

}
