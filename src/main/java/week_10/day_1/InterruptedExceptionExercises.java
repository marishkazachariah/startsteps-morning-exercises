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
    }
}
