
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Main {
    static void main(String[] args) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/input.txt");
        List<String> lines = readFile(path);
        ArrayList<Circle> circles = splitFile(lines);
        findDistAndCheck(circles);
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

    public static ArrayList<Circle> splitFile(List<String> lines) {
        ArrayList<Circle> circles = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int r = Integer.parseInt(parts[2]);
            Circle circle = new Circle(x, y, r);
            circles.add(circle);
        }
        return circles;
    }

    public static void findDistAndCheck(ArrayList<Circle> circles) {
        double dist = Circle.findDist(circles);
        if (circles.get(0).r + circles.get(1).r >= dist) {
            boolean res = Circle.checkIntersection(circles);
            if (res) {
                writeResult("Yes");
            } else {
                writeResult("NO");
            }
        } else {
            writeResult("NO");
        }
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
