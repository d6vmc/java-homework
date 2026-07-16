package homework_02_kayaks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        ArrayList<Integer> firstLine = getLine(lines, 0);
        ArrayList<Integer> secondLine = getLine(lines, 1);
        int maxWeight = firstLine.get(1);
        sortPeople(maxWeight, secondLine);
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_02_kayaks/input.txt");
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

    public static void sortPeople(int maxWeight, ArrayList<Integer> secondLine) {
        int counter = 0;
        while (!secondLine.isEmpty()) {
            int max = findMax(secondLine);
            if (secondLine.size() == 1) {
                secondLine.remove(Integer.valueOf(max));
                counter++;
                break;
            }
            int min = findMin(secondLine);
            if (max + min <= maxWeight) {
                secondLine.remove(Integer.valueOf(max));
                secondLine.remove(Integer.valueOf(min));
            } else {
                secondLine.remove(Integer.valueOf(max));
            }
            counter++;
        }
        writeResult(String.valueOf(counter));
    }

    public static int findMin(ArrayList<Integer> line) {
        int min = 15001;
        for (int i = 0; i < line.size(); i++) {
            if (line.get(i) < min) {
                min = line.get(i);
            }
        }
        return min;
    }

    public static int findMax(ArrayList<Integer> line) {
        int max = 0;
        for (int i = 0; i < line.size(); i++) {
            if (line.get(i) > max) {
                max = line.get(i);
            }
        }
        return max;
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_02_kayaks/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }


}
