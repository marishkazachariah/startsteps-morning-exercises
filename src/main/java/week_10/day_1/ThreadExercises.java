package week_10.day_1;

public class ThreadExercises {
    public static void main(String[] args) {
        // Exercise 1
        Thread countingThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
            }
        });
         countingThread.start();

        // Exercise 2
        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0 && i != 0) {
                    System.out.println(i);
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        });
        evenThread.start();
        try {
            evenThread.join();
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        oddThread.start();

        // Exercise 3
        Thread clockThread = new Thread(() -> {
            try {
                while (true) {
                    long currentTime = System.currentTimeMillis();

                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
                    String formatTime = sdf.format(new java.util.Date(currentTime));

                    System.out.println("Current time: " + formatTime);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        clockThread.start();

        // Exercise 4
        Thread countdownThread = new Thread(() -> {
            int COUNTDOWN_TIMER = 10;
            try {
                do {
                    System.out.println("Current time: " + COUNTDOWN_TIMER--);
                    Thread.sleep(1000);
                }
                while (COUNTDOWN_TIMER >= 0);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        countdownThread.start();
    }
}
