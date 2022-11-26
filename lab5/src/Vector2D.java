import java.util.Arrays;

public class Vector2D implements IVector{
    private final double x,y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double abs() {
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public double cdot(IVector iVector) {
        double[] v = iVector.getComponents();
        return x*v[0]+y*v[1];
    }

    @Override
    public double[] getComponents() {
        double[]components = new double[2];
        components[0] = x;
        components[1] = y;
        return components;
    }

    public void printCartesian(){
        System.out.println("Współrzedne kartezjańskie: [x, y] = " + Arrays.toString(getComponents()));
    }
}
