package week_8.day_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/*
Exercise 1: Counting Words in a File
Create a Java program that reads a text file and counts the number of words in it.

Bonus: Extend the program to display the frequency of each word in the text.

Exercise 2: Reading User Input until 'Exit'
Create a program where users can keep entering strings into the console. The program should terminate when the user types 'Exit'.

Bonus: Store all the entered strings in an ArrayList and, upon exit, write all the strings to a file named "userInputs.txt".

Exercise 3: Appending to a File
Create a program that allows the user to add more content to an existing file without overwriting its previous content.

Bonus: Before appending, check if the content already exists in the file. If it does, notify the user instead of appending.

Exercise 4: Reading a Properties File
Create a program that reads key-value pairs from a .properties file and prints them to the console.

Bonus: Allow the user to search for a specific key and display its corresponding value, notifying the user if the key doesn't exist.

Exercise 5: Creating Directories
Create a program that allows users to specify a path, and the program should create a directory at that specified location.

Bonus: Allow the creation of nested directories based on user input, like "folder/subfolder/subsubfolder".
 */
public class AdditionalExercises {
    public static void main(String[] args) {
        // Exercise 1
        int numberOfWords = 0;
        // Bonus
        Map<String, Integer> wordFrequency = new HashMap<>();

        String csvFilePath = "src/main/java/week_8/day_1/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s");
                numberOfWords += words.length;
                for (String word: words) {
                    // Remove punctuation and convert to lowercase for better word matching
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of words in the file: " + numberOfWords);
        // Bonus
        for(Map.Entry<String,Integer> entry: wordFrequency.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // Exercise 2
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Write as many words. Type \"exit\" to exit.");
            String input = sc.nextLine();
            if (input.toLowerCase().contains("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("Words entered: " + input);
        }
        sc.close();
    }

    // Exercise 3
    public static void exerciseThree() {
        String filePath = "src/main/java/week_8/day_1/append_existing_file.txt";

        // The "true" parameter enables append mode
        try (FileWriter writer = new FileWriter(filePath, true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter text to append to the file. Type 'Exit' to finish.");

            while (true) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Exit")) {
                    System.out.println("Content appended to the file.");
                    break;
                }

                writer.write(input + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Exercise 4
    public static void exerciseFour() {
        String filePath = "src/main/java/week_8/day_1/config.properties";

        try (FileInputStream input = new FileInputStream(filePath)) {
            Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void exerciseFive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path to create a directory: ");
        String filePath = sc.next();
        System.out.println("Enter the name of the desired a directory: ");
        filePath = filePath + sc.next();

        //Creating a File object
        File file = new File(filePath);

        //Creating the directory
        boolean bool = file.mkdir();
        if(bool){
            System.out.println("Directory created successfully");
        }else{
            System.out.println("Could not create specified directory");
        }
    }
}