public class Polar2DInheritance extends Vector2D{
    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle(){
        double[] components = super.getComponents();
        return Math.atan2(components[1], components[0])*180/Math.PI;
    }

}
