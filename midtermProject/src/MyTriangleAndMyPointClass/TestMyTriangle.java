package MyTriangleAndMyPointClass;

public class TestMyTriangle {
    public static void main(String[] args) {
        // Test
        MyTriangle triangle1 = new MyTriangle(0, 0, 1, 0, 0, 1);
        System.out.println("Triangle 1: " + triangle1.toString());
        System.out.println("Perimeter: " + triangle1.getPerimeter());
        triangle1.printType(); System.out.println(); // Isosceles

        MyTriangle triangle2 = new MyTriangle(1, 0, 1, 0, 1, 0);
        System.out.println("Triangle 2: " + triangle2.toString());
        System.out.println("Perimeter: " + triangle2.getPerimeter());
        triangle2.printType(); System.out.println(); // Equilateral

        MyTriangle Triangle3 = new MyTriangle(0, 1, 2, 4, 4, 8);
        System.out.println("Triangle 3: " + Triangle3.toString());
        System.out.println("Perimeter: " + Triangle3.getPerimeter());
        Triangle3.printType(); System.out.println(); // Scalene

        // Test with MyPoint instances
        MyPoint point1 = new MyPoint(1, 2);
        MyPoint point2 = new MyPoint(3, 4);
        MyPoint point3 = new MyPoint(5, 6);
        System.out.println("Point 1: " + point1.toString());
        System.out.println("Point 2: " + point2.toString());
        System.out.println("Point 3: " + point3.toString());
        MyTriangle triangle4 = new MyTriangle(point1, point2, point3);
        System.out.println("Triangle 4: " + triangle4.toString());
        System.out.println("Perimeter: " + triangle4.getPerimeter());
        triangle2.printType();

    }
}
