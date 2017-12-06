package streams;

import streams.entities.Role;
import streams.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractise {

    public static void main(String[] args) {
        List<User> workList = createUsers();
        List<User> resultList = new ArrayList<>();


        long count = workList.stream()
                .filter(u -> u.getRole().getRoleName().equals("VIP-User"))
                .sorted((Comparator.comparing(User::getName)))
                .peek(u -> resultList.add(u))
                .count();
        System.out.println("Count of VIP users: " + count + ", sorted by name: ");
        resultList.forEach(System.out::println);

        System.out.println("|================================================================|");

        List <Role> roles = workList.stream()
                .filter(user -> user.getName().contains("ik"))
                .map(user -> new Role(user.getRole().getId(), user.getRole().getRoleName()))
                .distinct()
                .sorted((o1, o2) -> Long.compare(o1.getId(), o2.getId()))
                .collect(Collectors.toList());
        System.out.println("List of distinct roles of users that have 'ik' in name sorted by role id: " + roles);

        System.out.println("|================================================================|");

        List<Integer> i = Stream.iterate(0, n -> n +1)
                .limit(101)
                .skip(1)
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers of first 100 elements of infinite stream");
        i.forEach(integer -> System.out.print(integer + " "));

    }

    private static List <User> createUsers(){
        List <User> users = new ArrayList<>(Arrays.asList(
                new User(1L, "impavliuchenko@gmail.com", "Ivan", new Role(1, "Admin")),
                new User(2L, "sultan@gmail.com", "Alim", new Role(2, "User")),
                new User(3L, "yklis@gmail.com", "Yarik", new Role(3, "VIP-User")),
                new User(4L, "dvor@gmail.com", "Dvorik", new Role(2, "User")),
                new User(5L, "vistrel@gmail.com", "Dimon", new Role(3, "VIP-User")),
                new User(6L, "leha@gmail.com", "Leha", new Role(2, "User")),
                new User(7L, "totti@gmail.com", "Totti", new Role(3, "VIP-User"))
                ));
        return users;
    }
}
