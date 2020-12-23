package ey.mrndesign.matned.client.view;

public class Environment implements ViewEnvironment{

    private String image;
    private int xPos;
    private int yPos;
    private int xSize;
    private int ySize;

    public Environment(String image, int xPos, int yPos, int xSize, int ySize) {
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    @Override
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public int getxPos() {
        return xPos;
    }

    @Override
    public int getyPos() {
        return yPos;
    }

    @Override
    public int getxSize() {
        return xSize;
    }

    @Override
    public int getySize() {
        return ySize;
    }
}
