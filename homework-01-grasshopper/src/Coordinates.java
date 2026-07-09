package src;

import java.util.ArrayList;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double findDist(Coordinates coordA, Coordinates coordB) {
        double distX = calcDistX(coordA, coordB);
        double distY = calcDistY(coordA, coordB);
        double dist = sqrt(pow(distX, 2) + pow(distY, 2));
        return dist;
    }

    public static double calcDistX(Coordinates coordA, Coordinates coordB) {
        double distX = (double) abs(coordB.x - coordA.x);
        System.out.println(distX);
        return distX;
    }

    public static double calcDistY(Coordinates coordA, Coordinates coordB) {
        double distY = (double) abs(coordB.y - coordA.y);
        System.out.println(distY);
        return distY;
    }

    public static boolean checkIntersectionCoords(Coordinates coordA, Coordinates coordB, int L) {
        double dist = findDist(coordA, coordB);
        if (dist <= (double) L) {
            return true;
        } else {
            return false;
        }
    }
}
