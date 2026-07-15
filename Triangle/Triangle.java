import src.Coordinates;

public class Triangle {
    Point A;
    Point B;
    Point C;

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
    }

    public double perimeter() {
        double ab = A.distTo(B);
        double ac = A.distTo(C);
        double bc = B.distTo(C);
        return ab + ac + bc;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
