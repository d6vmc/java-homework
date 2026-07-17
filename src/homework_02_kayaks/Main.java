package homework_02_kayaks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        ArrayList<Integer> people = getLine(lines, 1);
        int maxWeight = getLine(lines, 0).get(1);
        int count = countKayaks3(maxWeight, people);
        writeResult(String.valueOf(count));
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

    public static int countKayaks(int maxWeight, ArrayList<Integer> people) {
        int counter = 0;
        while (!people.isEmpty()) {
            int max = findMax(people);
            if (people.size() == 1) {
                people.remove(Integer.valueOf(max));
                counter++;
                break;
            }
            int min = findMin(people);
            if (max + min <= maxWeight) {
                people.remove(Integer.valueOf(max));
                people.remove(Integer.valueOf(min));
            } else {
                people.remove(Integer.valueOf(max));
            }
            counter++;
        }
        return counter;
    }

    public static int countKayaks2(int maxWeight, ArrayList<Integer> people) {
        people.sort(null);
        int counter1 = 0;
        while (!people.isEmpty()) {
            int max = people.getLast();
            if (people.size() == 1) {
                people.removeFirst();
                counter1++;
                break;
            }
            int min = people.getFirst();
            if (max + min <= maxWeight) {
                people.removeLast();
                people.removeFirst();
            } else {
                people.removeLast();
            }
            counter1++;
        }
        return counter1;
    }

    public static int countKayaks3(int maxWeight, ArrayList<Integer> people) {
        people.sort(null);
        int counter1 = 0;
        int i = 0;
        int j = people.size()-1;
        while (i<=j) {
            if (i == j) {
                i++;
                counter1++;
            }
            int max = people.get(j);
            int min = people.get(i);

            if (max + min <= maxWeight) {
                j--;
                i++;
            } else {
                j--;
            }
            counter1++;
        }
        return counter1;
    }

    public static int findMin(ArrayList<Integer> people) {
        int min = 15001;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) < min) {
                min = people.get(i);
            }
        }
        return min;
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
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_02_kayaks/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
