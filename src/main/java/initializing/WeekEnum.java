package initializing;

public enum WeekEnum {

    Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6), Sunday(7);

    {
        System.out.println("enum anon block");
    }

    static {
        System.out.println("enum static block");
    }

    WeekEnum(int i) {
        System.out.println("enum constructor");
        System.out.println(i);
    }
}
