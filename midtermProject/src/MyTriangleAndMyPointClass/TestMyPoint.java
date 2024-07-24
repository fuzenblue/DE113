package MyTriangleAndMyPointClass;

public class TestMyPoint {

    // Test driver
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(0, 0);
        MyPoint point2 = new MyPoint(1, 0);
        MyPoint point3 = new MyPoint(0, 1);

        System.out.println("Point 1: " + point1.toString());
        System.out.println("Point 2: " + point2.toString());
        System.out.println("Point 2: " + point3.toString());

        System.out.println("Distance between Point 1 and Point 2: " + point1.distance(point2));
    }
}
