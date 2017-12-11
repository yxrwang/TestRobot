package au.com.arvis.model;

import au.com.arvis.business.EnvironmentAware;


public class Table implements EnvironmentAware{

    private int width;

    private int height;

    public Table(int width, int height){

        this.width = width;

        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean isSafe(Position position) {

        if(position != null){

            return (position.getX() < width && position.getY() < height);
        }

        return false;
    }
}
