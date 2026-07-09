package src1;

import java.util.ArrayList;

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

    public static double findDistBetweenCenters(Circle circle1, Circle circle2) {
        double distX = calcDistX(circle1, circle2);
        double distY = calcDistY(circle1, circle2);
        double dist = sqrt(pow(distX, 2) + pow(distY, 2));
        return dist;
    }

    public static boolean checkIntersection(ArrayList<Circle> circles) {
        Circle circle1 = circles.get(0);
        Circle circle2 = circles.get(1);

        double dist = findDist(circles);

        return abs(circle1.r - circle2.r) <= dist && dist <= abs(circle1.r + circle2.r);
    }


    public static boolean checkIntersection(Circle circle1, Circle circle2) {
        double dist = findDistBetweenCenters(circle1, circle2);
        return abs(circle1.r - circle2.r) <= dist && dist <= abs(circle1.r + circle2.r);
    }

    public static double calcDistX(Circle circle1,Circle circle2) {
        double distX = (double) abs(circle2.x - circle1.x);
        System.out.println(distX);
        return distX;
    }

    public static double calcDistY(Circle circle1,Circle circle2) {
        double distY = (double) abs(circle2.y - circle1.y);
        System.out.println(distY);
        return distY;
    }

}
