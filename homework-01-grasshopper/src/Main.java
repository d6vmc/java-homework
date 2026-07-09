package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/homework-01-grasshopper/src/input.txt");
        List<String> lines = readFile(path);
        Integer[] firstLine = getFirstLine(lines);
        Coordinates[] coords = splitFile(lines, firstLine[0]);
        Coordinates coordB = new Coordinates(firstLine[1], firstLine[2]);
        int L = firstLine[3];
        findAndCheck(coords, coordB, L);

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

    public static Coordinates[] splitFile(List<String> lines, int N) {
        Coordinates[] coords = new Coordinates[N];
        for (int i = 1; i <= N; i++) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            Coordinates coord = new Coordinates(x, y);
            coords[i-1] = coord;
        }
        return coords;
    }

    public static Integer[] getFirstLine(List<String> lines) {
        String line1 = lines.get(0);
        String[] parts1 = line1.split(" ");
        int N = Integer.parseInt(parts1[0]);
        int xB = Integer.parseInt(parts1[1]);
        int yB = Integer.parseInt(parts1[2]);
        int L = Integer.parseInt(parts1[3]);

        Integer[] line = new Integer[4];
        line[0] = N;
        line[1] = xB;
        line[2] = yB;
        line[3] = L;
        return line;
    }

    public static void findAndCheck(Coordinates[] coords, Coordinates coordB, int L) {
        for (int i = 0; i < coords.length; i++) {
            boolean res = Coordinates.checkIntersectionCoords(coords[i], coordB, L);
            if (res) {
                writeResult(String.valueOf(i+1));
                return;
            }
        }
        writeResult("YES");
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/homework-01-grasshopper/src/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }

}
