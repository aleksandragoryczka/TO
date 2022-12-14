package pl;

public class Coordinates {
    private final double posX, posY;

    public Coordinates(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString(){
        return "X: " + this.posX + "\tY: " + this.posY;
    }

}
