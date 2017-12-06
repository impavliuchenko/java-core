package streams;

import lambda.entities.Person;

import java.util.Arrays;
import java.util.List;

public class StreamSimpleExample {
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

        //print all age>20
        people.stream()
                .filter(person -> person.getAge()>20)
                .forEach(System.out::println);

        //the same for multithreading
        people.parallelStream()
                .filter(person -> person.getAge()>20)
                .forEach(System.out::println);

        //return count of found elements
        long count = people.stream()
                .filter(person -> person.getName().startsWith("D"))
                .count();
        System.out.println(count);


    }
}
