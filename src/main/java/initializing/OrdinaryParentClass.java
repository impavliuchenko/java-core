package initializing;

public class OrdinaryParentClass {
    int anInteger = returnInt();
    String aString = "1";
    static long aLong = staticReturnLong();

    {
        System.out.println("in block");
        showAll();
        anInteger++;
        aString = String.valueOf(Integer.valueOf(aString) + 1);
        aLong++;
    }

    static {
        System.out.println("in static block");
        showStatic();
        aLong++;
    }

    OrdinaryParentClass(){
        System.out.println("in Parent constructor");
        showAll();
        anInteger++;
        aString = String.valueOf(Integer.valueOf(aString) + 1);
        aLong++;
    }

    void showAll(){
        System.out.println("in showAll");
        System.out.println(anInteger + aString + aLong);
    }

    static void showStatic(){
        System.out.println("in showStatic");
        System.out.println(aLong);
    }

    int returnInt(){
        System.out.println("in returnInt");
        return 1;
    }

    static long staticReturnLong(){
        System.out.println("in staticReturnLong");
        return 1L;
    }
}
