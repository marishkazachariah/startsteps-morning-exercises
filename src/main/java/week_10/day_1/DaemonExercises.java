package week_10.day_1;

public class DaemonExercises {
    public static void main(String[] args) {
        // Exercise 2
        Exercise1 exercise1 = new Exercise1();
        exercise1.setDaemon(true);
        exercise1.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main task " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exercise 3
        Exercise1 exercise3 = new Exercise1();
        exercise3.setDaemon(true);
        exercise3.start();

        for (int i = 1; i <= 6; i++) {
            System.out.println("Starting Garbage Collector " + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exercise 4
        Thread musicPlayer = new Thread(() -> {
            while (true) {
                System.out.println("Playing background music");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        musicPlayer.setDaemon(true);
        musicPlayer.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main task " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Exercise 1
class Exercise1 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Background task running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Exercise3 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Cleaning up resources");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
