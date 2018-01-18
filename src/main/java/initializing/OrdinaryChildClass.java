package initializing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdinaryChildClass extends OrdinaryParentClass {

    static List list = fillList();

    {
        System.out.println("in child anon block");
    }

    static {
        System.out.println("in child static block");
        System.out.println(list);
    }

    OrdinaryChildClass() {
        System.out.println("in Child constructor");
    }

    static List fillList(){
        return Arrays.asList(1,2,3,4);
    }
}
