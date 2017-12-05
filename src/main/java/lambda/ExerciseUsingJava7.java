package lambda;

import lambda.entities.Person;
import lambda.interfaces.Condition;

import java.util.*;

public class ExerciseUsingJava7 {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person(1, "Ivan", 21),
                new Person(2, "Alim", 22),
                new Person(3, "Yarik", 21),
                new Person(4, "Leha", 22),
                new Person(5, "Dima", 21),
                new Person(6, "Dvorik", 20),
                new Person(7, "Katya", 20)
                );

        //sort by name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //print all people
        System.out.println("Print all: ");
        printAll(people);

        //print all people, which name starts with D
        System.out.println("Print custom: ");
        printAllNameWithD(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getName().startsWith("D");
            }
        });


    }

    private static void printAllNameWithD(List<Person> people, Condition condition) {
        for (Person p: people) {
            if (condition.test(p)){
                System.out.println(p);
            }
        }
    }

    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

