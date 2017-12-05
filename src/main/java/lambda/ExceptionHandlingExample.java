package lambda;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4,5,6};
        int key = 0;
        process(someNumbers, key, wrapperLambda((i, k) -> System.out.println(i / k)));

    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer){
        for (int i: someNumbers) {
            biConsumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer){
        return (i, k) -> {
            try {
                biConsumer.accept(i,k);
            }catch (ArithmeticException ae){
                System.out.println("Be careful: " + ae);
            }
        };
    }
}
