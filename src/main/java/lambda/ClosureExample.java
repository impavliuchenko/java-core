package lambda;

import lambda.interfaces.Process;

public class ClosureExample {
    public static void main(String[] args) {
        int a = 10;

        //effective final variable for lambda, if we change it - compile error
        int b = 20;

        doProcess(a, (i -> System.out.println(i + b)));
    }

    private static void doProcess(int i, Process process){
        process.process(i);
    }
}
