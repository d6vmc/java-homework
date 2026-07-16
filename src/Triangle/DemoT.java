package Triangle;

import homework_01_grasshopper.Coordinates;

public class DemoT {
    static void main(String[] args) {
        Triangle tr = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        System.out.println(tr.perimeter());
        System.out.println(tr);
    }
}
