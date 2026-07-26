package homework_04_person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        ArrayList<Person> personsMath = readPersons("/Users/devmc/IdeaProjects/Homework/src/homework_04_person/listPersonsMath.txt");
        ArrayList<Person> personsPhysics = readPersons("/Users/devmc/IdeaProjects/Homework/src/homework_04_person/listPersonsPhysics.txt");

        System.out.println(personsMath);

        for (int i = 0; i < personsMath.size(); i++) {
            for (int j = 0; j < personsPhysics.size(); j++) {
                if (personsMath.get(i).equals(personsPhysics.get(j))) {
                    System.out.println(personsMath.get(i) + " сдает и физику, и математику");
                }
            }
        }
    }

    public static List<String> readFile(String name) {
        Path path = Path.of(name);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return List.of();
        }
    }

    public static ArrayList<Person> readPersons(String name) {
        List<String> lines = readFile(name);
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i).split(" ");
            String personName = line[0];
            String surname = line[1];
            int age = Integer.parseInt(line[2]);
            String city = line[3];
            String number = line[4];
            Person person = new Person(personName, surname, age, city, number);
            persons.add(person);
        }
        return persons;
    }


}
