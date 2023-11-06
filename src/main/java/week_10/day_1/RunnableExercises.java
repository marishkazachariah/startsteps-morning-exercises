package week_10.day_1;

public class RunnableExercises {
    public static void main(String[] args) throws InterruptedException {
        // Exercise 1
        Runnable alphabetRunnable = () -> {
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.println(i);
            }
        };
        Thread alphabetThread = new Thread(alphabetRunnable);
        alphabetThread.start();
        alphabetThread.join();

        // Exercise 2
        Runnable cookingRunnable = () -> {
            while (true) {
                System.out.println("Cooking");
                try {
                    Thread.sleep(1000); // Simulate eating for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable eatingRunnable = () -> {
            while (true) {
                System.out.println("Eating");
                try {
                    Thread.sleep(1000); // Simulate eating for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread cookingThread = new Thread(cookingRunnable);
        Thread eatingThread = new Thread(eatingRunnable);

        cookingThread.start();
        eatingThread.start();

        // Exercise 3
        int[] arr = {3, 4, 5, 2, 5, 1};
        Runnable sumRunnable = new Runnable() {
            int sum = 0;
            @Override
            public void run() {
                for(int num : arr) {
                    sum += num;
                }
                System.out.println("sum: " + sum);
            }
        };
        Thread sumThread = new Thread(sumRunnable);
        sumThread.start();
    }
}
