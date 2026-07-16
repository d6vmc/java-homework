package Triangle;

import homework_01_grasshopper.Coordinates;

public class Point extends Coordinates {

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
