package week_10.day_3;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    public static void main(String[] args) {
        // Exercise 1
        java.util.concurrent.ScheduledExecutorService exercise1 = Executors.newScheduledThreadPool(1);

        Runnable scheduledTask = () -> System.out.println("I'm scheduled!");

        exercise1.schedule(scheduledTask, 2, TimeUnit.SECONDS);

        exercise1.shutdown();

        // Exercise 2
        java.util.concurrent.ScheduledExecutorService exercise2 = Executors.newScheduledThreadPool(1);

        Runnable repeatingTask = () -> System.out.println("Repeating task");

        exercise2.scheduleAtFixedRate(repeatingTask, 0, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exercise2.shutdown();
    }
}
