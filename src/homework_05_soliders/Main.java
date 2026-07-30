package homework_05_soliders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        int rowsCount = getRow(lines, 0).get(1);
        ArrayList<Integer> resArray = calcAllJumps(lines, rowsCount);
        int res = findRes(resArray);
        writeResult(String.valueOf(res));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_05_soliders/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Integer> getRow(List<String> lines, int rowNumber) {
        ArrayList<Integer> row = new ArrayList<>();
        String line = lines.get(rowNumber);
        String [] parts = line.split(" ");
        for (String part : parts) {
            row.add(Integer.parseInt(part));
        }
        return row;
    }

    public static int calcJumpsInRow(ArrayList<Integer> row) {
        int counter = 0;
        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (row.get(j) > row.get(i)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static ArrayList<Integer> calcAllJumps(List<String> lines, int rowsCount) {
        ArrayList<Integer> jumps = new ArrayList<>();

        for (int i = 1; i <= rowsCount; i++) {
            ArrayList<Integer> row = getRow(lines, i);
            jumps.add(calcJumpsInRow(row));
        }
        System.out.println(jumps);
        return jumps;
    }

    public static int findRes(ArrayList<Integer> jumps) {
        int max = jumps.stream().max(Integer::compareTo).get();
        int index = jumps.indexOf(max);
        return index + 1;
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_05_soliders/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
