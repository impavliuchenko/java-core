package lambda;

public class MethodReferenceExample1 {

    public static void main(String[] args) {
        //instead of this lambda expression, where the arguments of two methods(which put and in what we put) are the same
        Thread thread1 = new Thread(() -> printMessage());

        //we can use method reference. Syntax.. (ClassWhereTheMethodLocated::methodName)
        Thread thread2 = new Thread(MethodReferenceExample1::printMessage);

        thread1.start();
        thread2.start();
    }

    public static void printMessage(){
        System.out.println("Message");
    }
}
