package workonlesson_cellphone;

public class Station {
    String name;
    Coordinates place;
    int cellLen;

    public Station(String name, Coordinates place, int cellLen) {
        this.name = name;
        this.place = place;
        this.cellLen = cellLen;
    }

    public Station(String name, int x, int y, int cellLen) {
        this.name = name;
        this.place = new Coordinates(x, y);
        this.cellLen = cellLen;
    }

    public boolean checkRange(Coordinates coord) {
        return place.distTo(coord) <= cellLen;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", place=" + place +
                ", cellLen=" + cellLen +
                '}';
    }

    public String getName() {
        return name;
    }
}
