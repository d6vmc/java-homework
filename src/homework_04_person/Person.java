package homework_04_person;

import java.util.Objects;

public class Person {
    String name;
    String surname;
    int age;
    String city;
    String number;

    public Person(String name, String surname, int age, String city, String number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(city, person.city) && Objects.equals(number, person.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city, number);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
