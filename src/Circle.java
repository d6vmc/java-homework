import java.util.ArrayList;
import java.util.TreeMap;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class Circle {
    int x;
    int y;
    int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static double findDist(ArrayList<Circle> circles) {
        Circle circle1 = circles.getFirst();
        Circle circle2 = circles.get(1);
        double distX = calcDistX(circle1, circle2);
        double distY = calcDistY(circle1, circle2);
        double dist = sqrt(pow(distX, 2) + pow(distY, 2));
        return dist;
    }

    public static boolean checkIntersection(ArrayList<Circle> circles) {
        if (maxR(circles) <= calcDistX(circles.get(0), circles.get(1)) + minR(circles) || maxR(circles) <= calcDistY(circles.get(0), circles.get(1)) + minR(circles)) {
            return true;
        } else {
            return false;
        }
    }

    public static double maxR(ArrayList<Circle> circles) {
        return (double) max(circles.get(0).r, circles.get(1).r);
    }

    public static double minR(ArrayList<Circle> circles) {
        return (double) min(circles.get(0).r, circles.get(1).r);
    }

    public static double calcDistX(Circle circle1,Circle circle2) {
        double distX = (double) abs(circle2.x - circle1.x);
        return distX;
    }

    public static double calcDistY(Circle circle1,Circle circle2) {
        double distY = (double) abs(circle2.y - circle1.y);
        return distY;
    }

}
