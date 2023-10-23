package week_8.day_1;

import java.io.*;
import java.util.Scanner;

/*
Exercise 1: Reading from the Console
Ask your students to create a Java program that reads a line of text from the console using the Scanner class.
Instruct them to display the entered text on the console.
Exercise 2: Writing to the Console
Have your students create a Java program that prompts the user for their name and then displays a greeting message on the console.
They should use the System.out.println() method to print the message.
Exercise 3: Reading and Writing to Files
Challenge your students to create a program that reads a text file called "input.txt" and writes its content to a new file called "output.txt."
They should use FileReader and FileWriter to accomplish this task.
Exercise 4: Copying a File
Instruct your students to create a Java program that copies the content of one file (e.g., "source.txt") to another file (e.g., "destination.txt").
They should use FileInputStream and FileOutputStream for binary file copying.
Exercise 5: Reading and Writing CSV Files
Have your students create a program that reads data from a CSV file (comma-separated values) called "data.csv" and prints it to the console.
Encourage them to use BufferedReader to read the file line by line.
Exercise 6: Error Handling
Introduce error handling by asking your students to modify their programs to handle exceptions that may occur during I/O operations.
Encourage them to use try-catch blocks to gracefully handle these exceptions.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exercise 1:
        System.out.print("Enter a line of text: ");
        String inputText = sc.nextLine();
        System.out.println("Result: " + inputText);
        System.out.println("**************");

        // Exercise 2:
        System.out.println("Please enter your name: ");
        String name = sc.next();
        System.out.println("My name is: " + name);

        sc.close();

        // Exercise 3:
        FileReader fileReader = null;
        String outputFilePath = "src/main/java/week_8/day_1/output.txt";
        StringBuilder textToOutput = new StringBuilder();

        // read file
        try {
            fileReader = new FileReader("src/main/java/week_8/day_1/input.txt");
            int character;
            while((character = fileReader.read()) != -1) {
                char c = (char) character;
                textToOutput.append(c);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // write file
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(textToOutput.toString());
            System.out.println(".txt file create: " + outputFilePath);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Exercise 4
        String sourceFilePath = "src/main/java/week_8/day_1/source.txt";
        String destinationFilePath = "src/main/java/week_8/day_1/destination.txt";

        try(FileInputStream inputStream = new FileInputStream(sourceFilePath);
        FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {
            byte[] buffer = new byte[1024];

            int bytesRead;
            while((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("copied file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exercise 5
        String csvFilePath = "src/main/java/week_8/day_1/test_cv_file.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line into individual values using a comma as the delimiter
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + "\t"); // Use "\t" for tab-separated output
                }

                // Print a newline character to separate rows
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
