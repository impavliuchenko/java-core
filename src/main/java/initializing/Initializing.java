package initializing;

public class Initializing {
    public static void main(String[] args) {
        OrdinaryParentClass ordinaryClass = new OrdinaryChildClass();
        ordinaryClass.showAll();
//        OrdinaryChildClass.showStatic();
        System.out.println(OrdinaryChildClass.class.getClassLoader());
//        System.out.println(String.class.getClassLoader());
        System.out.println(Week.Friday);
    }
}
