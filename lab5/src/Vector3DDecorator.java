import java.util.Arrays;

public class Vector3DDecorator implements IVector{
    private final IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector vec, double z){
        this.srcVector = vec;
        this.z = z;
    }

    public Vector3DDecorator(IVector vec){
        this.srcVector = vec;
        this.z = 0;
    }

    @Override
    public double abs() {
        double []components = srcVector.getComponents();
        return Math.sqrt(components[0]*components[0]+components[1]*components[1]+z*z);
    }

    @Override
    public double cdot(IVector iVector) {
        double[] components = iVector.getComponents();
        double[] v2 = this.getComponents();
        return components[0]*v2[0]+components[1]*v2[1]+components[2]*v2[2];
    }

    @Override
    public double[] getComponents() {
        double[]components;
        components = srcVector.getComponents();
        return new double[]{components[0], components[1], z};
    }

    public Vector3DDecorator cross(IVector iVector){
        double []v1 = getComponents();
        double []v2 = iVector.getComponents();

        double i,j,k;
        i = v1[1]*v2[2]-v1[2]*v2[1];
        j = v1[2]*v2[0]-v1[0]*v2[2];
        k = v1[0]*v2[1]-v1[1]*v2[0];

        return new Vector3DDecorator(new Vector2D(i,j), k);
    }

    public IVector getSrc(){
        return this.srcVector;
    }

    public void printCrossProduct(Vector3DDecorator v2){
        System.out.println(Arrays.toString(this.cross(v2).getComponents()));
    }

    public void print3d(){
        System.out.println("Współrzedne: [x, y, z] = " + Arrays.toString(getComponents()));
    }



}
