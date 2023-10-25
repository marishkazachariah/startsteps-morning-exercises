package week_8.day_3;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
Exercise 1: Reading from a File
Ask your students to create a Java program that reads text from a file called "input.txt" using FileReader.
Instruct them to display the content of the file on the console.
Exercise 2: Writing to a File
Have your students create a Java program that writes a sentence of their choice to a file called "output.txt" using FileWriter.
Encourage them to use FileWriter to write the sentence to the file.
Exercise 3: Copying a File
Challenge your students to create a Java program that reads content from one file (e.g., "source.txt") using FileReader and writes it to another file (e.g., "destination.txt") using FileWriter.
Make sure they handle any potential exceptions that may occur during file operations.
Exercise 4: Appending to a File
Instruct your students to modify the previous program to append additional text to the "destination.txt" file instead of overwriting its content.
They should use FileWriter in append mode to achieve this.
Exercise 5: Reading and Writing Numbers
Have your students create a program that reads a series of integers from an "input_numbers.txt" file using FileReader.
Then, ask them to calculate the sum of these numbers and write the result to an "output_sum.txt" file using FileWriter.
Exercise 6: Error Handling
Introduce error handling by asking your students to modify their programs to handle exceptions that may occur during file operations (e.g., FileNotFoundException, IOException).
Encourage them to use try-catch blocks to gracefully handle these exceptions.
 */

public class Main {
    public static void exerciseOne() {
        try (FileReader fileReader = new FileReader("src/main/java/week_8/day_3/input.txt")) {
            int x;
            StringBuilder contentsOfFile = new StringBuilder();
            while ((x = fileReader.read()) != -1) {
                contentsOfFile.append((char) x);
            }
            System.out.println(contentsOfFile.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void exerciseTwo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write a sentence of your choice. Press ENTER key to submit.");
        String wordsToOutput = sc.nextLine();
        try (FileWriter fileWriter = new FileWriter("src/main/java/week_8/day_3/output.txt")) {
            fileWriter.write(wordsToOutput);
            System.err.println("Finished writing file to output.txt");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
        sc.close();
    }

    public static void exerciseThree() {
        try(FileReader fileReader = new FileReader("src/main/java/week_8/day_3/source.txt");
            FileWriter fileWriter = new FileWriter("src/main/java/week_8/day_3/destination.txt", true);) {
            int x;
            StringBuilder contentsOfFile = new StringBuilder();
            while ((x = fileReader.read()) != -1) {
                contentsOfFile.append((char) x);
            }
            fileWriter.write(String.valueOf(contentsOfFile));
            System.out.println("Copied file successfully to destination.txt");

            // Exercise Four
            Scanner sc = new Scanner(System.in);
            System.out.println("Add more text to append to file");
            String additionalText = sc.nextLine();
            fileWriter.write("\n" + additionalText + "\n");
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }

    public static void exerciseFive() {
        try (FileReader fileReader = new FileReader("src/main/java/week_8/day_3/input_numbers.txt");
            FileWriter fileWriter = new FileWriter("src/main/java/week_8/day_3/output_sum.txt")) {
            int x;
            StringBuilder contentsOfFile = new StringBuilder();
            while ((x = fileReader.read()) != -1) {
                contentsOfFile.append((char) x);
            }

            String integers = contentsOfFile.toString();
            String[] numbers = integers.split(",");
            int sum = 0;

            for (String number: numbers ) {
                sum += Integer.parseInt(number.trim());
                System.out.println(sum);
            }
            fileWriter.write(String.valueOf(sum));
            System.out.println("Output sum successfully in output_sum.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        exerciseOne();
        exerciseTwo();
        exerciseThree();
        exerciseFive();
    }
}
