package src1;

import src.Coordinates;

import static java.lang.Math.abs;

public class Circle2 {
    Coordinates center;
    int r;

    public Circle2(int x, int y, int r) {
        this.r = r;
        this.center = new Coordinates(x, y);
    }

    public boolean checkIntersectionWith(Circle2 c) {
        return center.distTo(c.center) <= r + c.r && abs(r-c.r) >= center.distTo(c.center);
    }
}
