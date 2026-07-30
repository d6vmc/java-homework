package homework_04_dragons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        int heads = Integer.parseInt(lines.getFirst());
        int res = calcMaxPower(heads);
        writeResult(String.valueOf(res));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_04_dragons/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static int calcMaxPower(int heads) {
        int count3 = 0;
        int lastNumber = 0;
        if (heads%3 == 0) {
            count3 = heads/3;
        } else {
            count3 = heads/3;
            lastNumber = heads - 3 * count3;
            if (lastNumber<2) {
                count3 -= 1;
                lastNumber = 4;
            }
        }
        return (int) (Math.pow(3, count3) * lastNumber);
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_04_dragons/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
