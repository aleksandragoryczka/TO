import java.util.Arrays;

public class Main {
    public static void main(String [] args) {
        Vector2D v1 = new Vector2D(1, 2);
        Vector2D v2 = new Vector2D(3, -5);
        Vector2D v3 = new Vector2D(10,10);

        Polar2DAdapter v1Adapted = new Polar2DAdapter(v1);
        Polar2DAdapter v2Adapted = new Polar2DAdapter(v2);
        Polar2DAdapter v3Adapted = new Polar2DAdapter(v3);

        Vector3DDecorator v1_3d = new Vector3DDecorator(v1);
        Vector3DDecorator v2_3d = new Vector3DDecorator(v2);
        Vector3DDecorator v3_3d = new Vector3DDecorator(v3, 5);

        System.out.println("v1: ");
        v1.printCartesian();
        v1Adapted.printPolar();

        System.out.println("\nv2: ");
        v2.printCartesian();
        v2Adapted.printPolar();

        System.out.println("\nv3: ");
        v3.printCartesian();
        v3Adapted.printPolar();

        System.out.println("\nv1_3d: ");
        v1_3d.print3d();

        System.out.println("\nv2_3d: ");
        v2_3d.print3d();

        System.out.println("\nv3_3d: ");
        v3_3d.print3d();

        System.out.println("\nILOCZYNY SKALARNE: ");
        System.out.println("v1 * v2 = " + v1.cdot(v2));
        System.out.println("v1 * v3 = " + v1.cdot(v3));
        System.out.println("v2 * v3 = " + v2.cdot(v3));
        System.out.println("v1 * v1 = " + v1.cdot(v1));
        System.out.println("v2 * v2 = " + v2.cdot(v2));
        System.out.println("v3 * v3 = " + v3.cdot(v3));

        System.out.println("\nILOCZYNY WEKTOROWE: ");
        System.out.print("v1_3d x v2_3d = ");
        v1_3d.printCrossProduct(v2_3d);
        System.out.print("v1_3d x v3_3d = ");
        v1_3d.printCrossProduct(v3_3d);
        System.out.print("v2_3d x v3_3d = ");
        v2_3d.printCrossProduct(v3_3d);

        System.out.print("v2_3d x v1_3d = ");
        v2_3d.printCrossProduct(v1_3d);
        System.out.print("v3_3d x v1_3d = ");
        v3_3d.printCrossProduct(v1_3d);
        System.out.print("v3_3d x v2_3d = ");
        v3_3d.printCrossProduct(v2_3d);
    }
}