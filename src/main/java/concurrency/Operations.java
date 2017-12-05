package concurrency;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.TimeUnit;

public class Operations {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Account ac1 = new Account(1000);
        Account ac2 = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Hello from New!");
                    transfer(ac1, ac2, 100);
                } catch (InsufficientResourcesException e) {
                    System.out.println("No money from new Thread");
                }
            }
        }).start();

        try {
            System.out.println("Hello from ExerciseUsingJava7!");
            transfer(ac2, ac1, 100);
        } catch (InsufficientResourcesException e) {
            System.out.println("No money from main Thread");
        }
    }

    static void transfer(Account ac1, Account ac2, int amount) throws InsufficientResourcesException {

        System.out.println(ac1.getCount().incrementAndGet());
        System.out.println(ac2.getCount().incrementAndGet());

        try {
            if (ac1.getLock().tryLock(1, TimeUnit.SECONDS)) {
                try {
                    if ((ac2.getLock().tryLock(1, TimeUnit.SECONDS))) {
                        try {

                            Thread thread = Thread.currentThread();

                            if (ac1.getBalance()<amount){
                                throw new InsufficientResourcesException();
                            }

                            ac1.withdraw(amount);
                            ac2.deposit(amount);

                            System.out.println("From  " + thread.getName() + ": " + ac1.getBalance() + " " + ac2.getBalance());

                        }finally {
                            ac2.getLock().unlock();
                            System.out.println("Unlock ac2");
                            ac1.getLock().unlock();
                            System.out.println("Unlock ac1");
                        }
                    }else {
                        System.out.println("Too long waiting inner");
                    }

                } finally {

                }

            }else {
                System.out.println("Too long waiting");
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}