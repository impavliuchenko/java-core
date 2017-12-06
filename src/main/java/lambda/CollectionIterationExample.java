package lambda;

import lambda.entities.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
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

        // these 2 bottom loops called EXTERNAL iterators in the sense that
        // I'm managing the iteration process - controlling it
        System.out.println("Using ordinary for loop");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println("Using for-each loop");
        for (Person p: people) {
            System.out.println(p);
        }


        System.out.println("Using .forEach() method");
        //.forEach(Consumer consumer) come with Functional interface Consumer as a param,
        // so we can pass inside the lambda expression like (p -> p.someAction())
        //or (p -> someAction(p)) that transform to (SomeClass::someMethod)
        //called INTERNAL iterators - I'm giving the control to sb else -
        //just telling the runtime - I want to iterate over this people list.
        //It's easy for processors to run in multiple Threads
        people.forEach(System.out::println);

    }
}
