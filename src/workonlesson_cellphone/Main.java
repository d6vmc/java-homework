package workonlesson_cellphone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    static void main(String[] args) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/workonlesson_cellphone/input.txt");
        ArrayList<Station> stations = parseStations(path);
        Coordinates userCoords = readCoords(path);
        long count = stations.stream().map(Station::getName).distinct().count();
        System.out.println(count);
        var x = countGoodStations(userCoords, stations);
        System.out.println(x);

    }

    public static List<String> readFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Station> parseStations(Path path) {
        List<String> lines = readFile(path);
        ArrayList<Station> stations = new ArrayList<>();
        int firstLine = Integer.parseInt(lines.getFirst());
        for (int i = 1; i <= firstLine*2-1; i+=2) {
            String name = lines.get(i);
            String line = lines.get(i+1);
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[2]);
            Station station = new Station(name, x, y, r);
            stations.add(station);
        }
        return stations;
    }

    public static Coordinates readCoords(Path path) {
        String[] parts = readFile(path).getLast().split(" ");
        return new Coordinates(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    public static Map<String, Integer> countGoodStations(Coordinates userCoords, ArrayList<Station> stations) {
        Map<String, Integer> result = new LinkedHashMap<>();
        stations.stream().filter(station -> station.checkRange(userCoords))
                .map(station -> station.getName())
                .forEach(s -> {
                    result.put(s, result.getOrDefault(s, 0)+1);
                });
//        stations.stream().filter(station -> !station.checkRange(userCoords))
//                .map(station -> station.getName())
//                .forEach(s -> {
//                    if (!result.containsKey(s)) {
//                        result.put(s, 0);
//                    }
//                });
        stations.stream().filter(station -> !station.checkRange(userCoords))
                .map(Station::getName)
                .filter(s -> !result.containsKey(s))
                .forEach(s -> result.put(s, 0));
        return result;
    }










}
