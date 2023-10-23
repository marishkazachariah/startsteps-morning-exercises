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
        }

        // write file
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(textToOutput.toString());
            System.out.println(".txt file create: " + outputFilePath);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
