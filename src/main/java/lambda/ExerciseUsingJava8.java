package lambda;

import lambda.entities.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExerciseUsingJava8 {
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
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("Print all: ");
        //print all people
        printConditionally(people, p -> true);
        //same print by adding print behavior
        printConditionallyWithAddingPrintBehavior(people, p -> true, p -> System.out.println(p));

        //print all people, which name starts with D
        System.out.println("Print custom: ");
        printConditionally(people, p -> p.getName().startsWith("D"));
    }

    //Predicate - the out-of-the-box functional interface, that have abstract boolean method - that's what we need instead
    // of creating our own interface. There a lot of such "standart" interfaces.
    //For example - Supplier<T>: () -> ... return t; Function<T,R>: t -> ... return r; Consumer<T>: (t) -> void..; - see java.util.function.
    private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person p: people) {
            if (predicate.test(p)){
                System.out.println(p);
            }
        }
    }
    private static void printConditionallyWithAddingPrintBehavior(List<Person> people,
                                                             Predicate<Person> predicate,
                                                             Consumer<Person> consumer) {
        for (Person p: people) {
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
    }
}
