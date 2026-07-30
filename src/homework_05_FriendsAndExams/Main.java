package homework_05_FriendsAndExams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> lines = readFile();
        int countExamDates = getRow(lines, 0).get(0);
        ArrayList<Date> examDates1 = getExamDatesFirst(lines, countExamDates);
        ArrayList<Date> examDates2 = getExamDatesSecond(lines, countExamDates);
        ArrayList<Date> vacationDates = getVacationDates(lines, countExamDates);
        ArrayList<Date> resDates = findResDates(vacationDates, examDates1, examDates2);
        int countVacations = countVacations(resDates, vacationDates);
        writeResult(String.valueOf(countVacations));
    }

    public static List<String> readFile() {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_05_FriendsAndExams/input.txt");
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

    public static ArrayList<Date> getExamDatesFirst(List<String> lines, int countExamDates) {
        ArrayList<Date> examDates1 = new ArrayList<>();
        for (int i = 1; i < countExamDates+1; i++) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            int startDate = Integer.parseInt(parts[0]);
            int endDate = Integer.parseInt(parts[1]);
            examDates1.add(new Date(startDate, endDate));
        }
        return examDates1;
    }

    public static ArrayList<Date> getExamDatesSecond(List<String> lines, int countExamDates) {
        ArrayList<Date> examDates2 = new ArrayList<>();
        for (int i = 1; i < countExamDates+1; i++) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            int startDate = Integer.parseInt(parts[2]);
            int endDate = Integer.parseInt(parts[3]);
            examDates2.add(new Date(startDate, endDate));
        }
        return examDates2;
    }

    public static ArrayList<Date> getVacationDates(List<String> lines, int countExamDates) {
        ArrayList<Date> vacationDates = new ArrayList<>();
        for (int i = 1 + countExamDates; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            int startDate = Integer.parseInt(parts[0]);
            int endDate = Integer.parseInt(parts[1]);
            vacationDates.add(new Date(startDate, endDate));
        }
        return vacationDates;
    }

    public static ArrayList<Date> findResDates(ArrayList<Date> vacationDates, ArrayList<Date> examDates1, ArrayList<Date> examDates2) {
        ArrayList<Date> resDates = new ArrayList<>();
        for (int i = 0; i < examDates1.size(); i++) {
            int tmp1 = 0;
            int tmp2 = 0;
            for (int j = 0; j < vacationDates.size(); j++) {
                if (!vacationDates.get(j).intersects(examDates1.get(i))) {
                    tmp1++;
                }
               if (!vacationDates.get(j).intersects(examDates2.get(i))) {
                    tmp2++;
               }
            }
            if (tmp1 > tmp2) {
                resDates.add(examDates1.get(i));
            } else {
                resDates.add(examDates2.get(i));
            }
        }
        return resDates;
    }

    public static int countVacations(ArrayList<Date> resDates, ArrayList<Date> vacationDates) {
        for (int i=0; i < vacationDates.size(); i++) {
            for (int j = 0; j < resDates.size(); j++) {
                if (vacationDates.get(i).intersects(resDates.get(j))) {
                    vacationDates.remove(i);
                }
            }
        }
        return vacationDates.size();
    }

    public static void writeResult(String res) {
        Path path = Path.of("/Users/devmc/IdeaProjects/Homework/src/homework_05_FriendsAndExams/output.txt");
        try {
            Files.writeString(path, res);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
            e.printStackTrace();
        }
    }
}
