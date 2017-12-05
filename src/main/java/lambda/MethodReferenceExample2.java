package lambda;

import lambda.entities.Person;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
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


        //another example of using method reference instead of lambda like (p -> System.out.println(p))
        printConditionally(people, p -> true, System.out::println);
    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p: people) {
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

}
