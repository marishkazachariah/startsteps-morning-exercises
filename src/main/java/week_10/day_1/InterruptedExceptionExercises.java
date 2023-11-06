package week_10.day_1;

public class InterruptedExceptionExercises {
    public static void main(String[] args) {
        // Exercise 1
        Thread sleeperThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Awake");
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted while sleeping: " + e.getMessage());
            }
        });

        sleeperThread.start();

        // Exercise 2
        Thread longThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Long thread interrupted.");
                    return;
                }
            }
        });

        Thread interrupterThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                longThread.interrupt();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted while sleeping: " + e.getMessage());
            }
        });
        longThread.start();
        interrupterThread.start();
    }
}
