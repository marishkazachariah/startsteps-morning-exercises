package week_8.day_2;

import java.io.*;
import java.util.Arrays;

/*
Exercise 1: Write a Java program that reads a text file named "input.txt" using FileInputStream and displays its contents to the console.
Exercise 2: Enhance the program from Exercise 1 to handle exceptions gracefully. Implement error handling to catch and display any FileNotFoundException that may occur when attempting to read the file.
Exercise 3: Create a Java program that reads a binary file named "image.jpg" using FileInputStream and displays its content to the console. This exercise demonstrates reading binary data.
Exercise 4: Extend the program from Exercise 3 to create a new binary file named "copy_image.jpg" using FileOutputStream and write the content of "image.jpg" to the new file. Ensure that the new file is a copy of the original.
Exercise 5: Implement a program that reads a CSV file named "data.csv" using FileInputStream. Parse the CSV data and display it as a table in the console.
Exercise 6: Modify the program from Exercise 5 to handle exceptions. Implement error handling to catch and display any IOException that may occur while reading the file.
Exercise 7: Create a Java program that reads a large text file (e.g., "large_data.txt") in chunks using a buffer. Display the contents of the file in chunks, and specify the buffer size.
Exercise 8: Enhance the program from Exercise 7 to measure and display the time it takes to read the entire large file in milliseconds.
 */
public class Main {
    private static final String INPUT_PATH = "src/main/java/week_8/day_2/input.txt";
    private static final String INPUT_JPG_PATH = "src/main/java/week_8/day_2/linda.jpg";
    private static final String OUTPUT_JPG_PATH = "src/main/java/week_8/day_2/copy_image.jpg";
    private static final String INPUT_CSV_PATH = "src/main/java/week_8/day_2/test_cv_file.csv";
    private static final String INPUT_LARGE_FILE_PATH = "src/main/java/week_8/day_2/large_data.txt";

    public static void exerciseOne() {
        try (FileInputStream fileInputStream = new FileInputStream(INPUT_PATH)) {
            int x;
            while ((x = fileInputStream.read()) != -1) {
                System.out.println((char) x);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void exerciseThree() {
        try (FileInputStream fileInputStream = new FileInputStream(INPUT_JPG_PATH);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_JPG_PATH)) {
            int x;
            while ((x = fileInputStream.read()) != -1) {
                System.out.println((char) x);
                fileOutputStream.write((char) x);
            }
            System.out.println("copied image successfully");
        } catch (IOException e) {
            System.out.println("Error processing image file: " + e.getMessage());
        }
    }

    public static void exerciseFive() {
        try(FileInputStream fileInputStream = new FileInputStream(INPUT_CSV_PATH)) {
            int x;
            StringBuilder stringBuilder = new StringBuilder();
            while ((x = fileInputStream.read()) != -1) {
                stringBuilder.append((char) x);
            }
            String[] values = stringBuilder.toString().split(",");
            for (String value: values) {
                System.out.print(value + "\t");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error processing CSV file: " + e.getMessage());
        }
    }

    static void exerciseSeven() {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream(INPUT_LARGE_FILE_PATH);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

            int bufferSize = bufferedInputStream.available();
            byte[] buffer = new byte[bufferSize];
            int x;

            while ((x = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                 System.out.println(new String(buffer, 0, x));
            }

            System.out.println("Buffer size: " + bufferSize);
        } catch (Exception e) {
            System.out.println("Error processing large file: " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Total time it took to read file: " + elapsedTime + " milliseconds");
    }

    public static void main(String[] args) {
        exerciseOne();
        exerciseThree();
        exerciseFive();
        exerciseSeven();
    }
}
