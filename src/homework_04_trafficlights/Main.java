package homework_04_trafficlights;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        ArrayList<Integer> intersections = getIntersections(lines);
        String result = calcCountString(intersections);
        writeResult(result);
        int[] res = calcCountArray(intersections);
        System.out.println(Arrays.toString(res));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_04_trafficlights/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Integer> getIntersections(List<String> lines) {
        ArrayList<Integer> intersections = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String [] parts = line.split(" ");
            int first = Integer.parseInt(parts[0]);
            int second = Integer.parseInt(parts[1]);
            intersections.add(first);
            intersections.add(second);
        }
        return intersections;
    }

    public static String calcCountString(ArrayList<Integer> intersections) {
        intersections.sort(null);
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= intersections.getLast(); i++) {
            int counter = 0;
            for (int j = 0; j < intersections.size(); j++) {
                if (intersections.get(j) == i) {
                    counter+=1;
                } else if (intersections.get(j) > i){
                    break;
                }
            }
            res.append(counter).append(" ");

        }
        return res.toString().trim();
    }

    public static int[] calcCountArray(ArrayList<Integer> intersections) {
        int max = intersections.stream().max(Integer::compareTo).get();
        int[] res = new int[max];

        for (int node : intersections) {
            res[node-1]++;
        }
        return res;
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_04_trafficlights/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }

}
