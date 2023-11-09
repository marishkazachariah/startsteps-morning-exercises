package week_10.day_3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExercise implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}

class TestExecutor {
    public static void main(String[] args) {
        Executor executor = new ExecutorExercise();
        executor.execute(() -> System.out.println("Hello from Executor!"));
    }
}

class NumberPrintingTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            executor.submit(new NumberPrintingTask());
            executor.submit(new NumberPrintingTask());

            executor.shutdown();
        }
    }
}


