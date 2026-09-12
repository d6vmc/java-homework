package homework_07_alchemy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();

        Map<String, List<String>> graph = parseStrings(lines);
        int count = countTurns(graph, lines);
        writeResult(String.valueOf(count));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_07_alchemy/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static Map<String, List<String>> parseStrings(List<String> lines) {
        Map<String, List<String>> graph = new HashMap<>();

        int m = Integer.parseInt(lines.get(0).trim());

        for (int i = 1; i <= m; i++) {
            String line = lines.get(i).trim();

            String[] parts = line.split("\\s*->\\s*", 2);

            String from = parts[0];
            String to = parts[1];

            List<String> neighbors = graph.get(from);

            if (neighbors == null) {
                neighbors = new ArrayList<>();
                graph.put(from, neighbors);
            }

            neighbors.add(to);
        }
        return graph;
    }

    public static int countTurns(Map<String, List<String>> graph, List<String> lines) {
        int m = Integer.parseInt(lines.get(0).trim());

        String start = lines.get(m + 1).trim();
        String target = lines.get(m + 2).trim();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        visited.add(start);
        queue.add(start);
        parentMap.put(start, null);

        boolean pathfound = false;

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();

            if (Objects.equals(currentNode, target)) {
                pathfound = true;
                break;
            }

            List<String> neighbors = graph.getOrDefault(currentNode, Collections.emptyList());
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentNode);
                    queue.add(neighbor);
                }
            }
        }

        if (!pathfound) {
            return -1;
        }

        int reactions = 0;
        String current = target;
        while (!current.equals(start)) {
            current = parentMap.get(current);
            reactions++;
        }
        return reactions;
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_07_alchemy/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}



