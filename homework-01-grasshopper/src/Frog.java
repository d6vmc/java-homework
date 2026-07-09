package src;

public class Frog {
    Coordinates place;
    int tongueLen;

    public Frog(Coordinates place, int tongueLen) {
        this.place = place;
        this.tongueLen = tongueLen;
    }

    public Frog(int x, int y, int tongueLen) {
        this.place = new Coordinates(x, y);
        this.tongueLen = tongueLen;
    }

    public boolean checkRange(Coordinates coord) {
        return place.distTo(coord) <= tongueLen;
    }
}
