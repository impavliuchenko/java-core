package generics;

public class Main {
    public static void main(String[] args) {

        Mobile mobile1 = new Mobile(12,"sna", 100);
        Mobile mobile2 = new Mobile(20,"snaUsn", 200);

        Camera camera = new Camera(23,"",300);

        System.out.println(mobile1.personalCompare(mobile2));
        System.out.println(mobile1.compareTo(mobile2));

    }

}
