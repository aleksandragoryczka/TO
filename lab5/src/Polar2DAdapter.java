public class Polar2DAdapter implements IPolar2D,IVector {
    Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector){
        this.srcVector=srcVector;
    }

    @Override
    public double getAngle() {
        double[] components = srcVector.getComponents();
        return Math.atan2(components[1], components[0]);
    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    public double cdot(IVector iVector){
        return this.srcVector.cdot(iVector);
    }

    public double[] getComponents(){
        return this.srcVector.getComponents();
    }

    public void printPolar(){
        System.out.println("Współrzędne biegunowe: |r| = " + abs() + " phi = " + getAngle());
    }
}
