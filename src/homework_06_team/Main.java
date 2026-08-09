package homework_06_team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main(String[] args) {
        ArrayList<Integer> players = parsePlayers();
        System.out.println(players);
        ArrayList<Integer> maxPlayers = findMaxPlayers(players);
        System.out.println(maxPlayers);
        int max = maxPlayers.stream().max(Integer::compareTo).orElse(0);
        writeResult(String.valueOf(max));
    }


    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_06_team/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Integer> parsePlayers() {
        List<String> lines = readFile();
        ArrayList<Integer> players = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            players.add(Integer.parseInt(lines.get(i)));
        }
        return players;
    }

    public static ArrayList<Integer> findMaxPlayers(ArrayList<Integer> players) {
        ArrayList<Integer> maxRes = new ArrayList<>();
        players.sort(Comparator.reverseOrder());
        System.out.println(players);
        for (int i = 0; i < players.size(); i++) {
            int sum = 0;
            int first = players.get(i);
            sum+=first;
            for (int j = i+1; j < players.size(); j++) {
                sum += players.get(j);
                if (j + 1 < players.size()) {
                    if (first > players.get(j) + players.get(j + 1)) {
                        break;
                    }
                }
            }
            maxRes.add(sum);
        }
        return maxRes;
    }


    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_06_team/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
