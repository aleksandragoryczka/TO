public class Vector3DInheritance extends Vector2D{
    private double z;
    private IVector srcVector;


    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs(){
        double []components = super.getComponents();
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
        components = super.getComponents();
        return new double[]{components[0], components[1], z};
    }

    public Vector3DInheritance cross(IVector iVector){
        double []v1 = getComponents();
        double []v2 = iVector.getComponents();

        double i,j,k;
        i = v1[1]*v2[2]-v1[2]*v2[1];
        j = v1[2]*v2[0]-v1[0]*v2[2];
        k = v1[0]*v2[1]-v1[1]*v2[0];
        return new Vector3DInheritance(i,j,k);
    }

    public IVector getSrc(){
        double []components = getComponents();
        return new Vector2D(components[0], components[1]);
    }



}
