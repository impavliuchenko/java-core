package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int balance;
    private AtomicInteger count = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();

    public AtomicInteger getCount() {
        return count;
    }

    public Lock getLock() {
        return lock;
    }

    public Account(int initialBalance){
        this.balance = initialBalance;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
