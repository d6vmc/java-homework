package homework_03_hairbuisness;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        ArrayList<Integer> hairCost = getLine(lines, 1);
        int total = totalAmount(hairCost);
        writeResult(String.valueOf(total));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_03_hairbuisness/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Integer> getLine(List<String> lines, int lineCount) {
        String line1 = lines.get(lineCount);
        String[] parts1 = line1.split(" ");
        ArrayList<Integer> line = new ArrayList<>();
        for (int i = 0; parts1.length > i; i++) {
            line.add(Integer.parseInt(parts1[i]));
        }
        return line;
    }

    public static int totalAmount(ArrayList<Integer> hairCost) {
        int hairLength = 1;
        int sum = 0;
        for (int i = 0; i < hairCost.size(); i++) {
            if (hairCost.get(i) == findMax(hairCost)) {
                sum += hairCost.get(i) * hairLength;
                hairCost = new ArrayList<>(hairCost.subList(i + 1, hairCost.size()));
                hairLength = 0;
                i = -1;
            }
            hairLength++;
        }
        return sum;
    }

    public static int findMax(ArrayList<Integer> people) {
        int max = 0;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) > max) {
                max = people.get(i);
            }
        }
        return max;
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_03_hairbuisness/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}

