package week_8.day_3;

import java.io.*;
import java.util.*;

public class AdditionalExercises {
    public static void textCollectorWithUniqueness() throws IOException {
        Scanner sc = new Scanner(System.in);
        Set<String> uniqueWords = new HashSet<>();
        File file = new File("src/main/java/week_8/day_3/output2.txt");

        if(file.exists()) {
            try(FileReader fileReader = new FileReader("src/main/java/week_8/day_3/output2.txt")) {
                int x;
                StringBuilder contentsOfFile = new StringBuilder();
                while ((x = fileReader.read()) != -1) {
                    contentsOfFile.append((char) x);
                }
                System.out.println("Previous contents of file:\n" + contentsOfFile);
            } catch(FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }

        while(true) {
            System.out.println("Type in text to file. Type \"Export\" to append text to file.");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("Export")) {
                try(FileWriter fileWriter = new FileWriter("src/main/java/week_8/day_3/output2.txt", true)) {
                    for (String uniqueWord : uniqueWords) {
                        fileWriter.write(uniqueWord + ", ");
                    }
                    System.out.println("Unique words saved to \"output.txt\"");
                } catch (IOException e) {
                    System.err.println("An error occurred while writing to the file:" + e.getMessage());
                }
                break;
            } else {
                String[] words = input.split(" ");
                uniqueWords.addAll(Arrays.asList(words));
            }
        }
        sc.close();
    }

    public static void lineCounter() throws FileNotFoundException {
        String inputFilePath = "src/main/java/week_8/day_3/input.txt";

        try (FileReader fileReader = new FileReader(inputFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int lineCount = 0;

            while (bufferedReader.readLine() != null) {
                lineCount++;
            }

            System.out.println("Total number of lines in the file: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void convertToUpperCase() {
        String inputFilePath = "src/main/java/week_8/day_3/input.txt";
        String outputFilePath = "src/main/java/week_8/day_3/outputToUppercase.txt";
        StringBuilder textToOutput = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(inputFilePath);
             FileWriter fileWriter = new FileWriter(outputFilePath)) {
            int character;

            while ((character = fileInputStream.read()) != -1) {
                char c = (char) character;
                textToOutput.append(c);
            }

            String finalOutput = textToOutput.toString().toUpperCase();
            fileWriter.write(finalOutput);
            System.out.println("converted text to uppercase letters in outputToUppercase.txt");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    public static void findDuplicatedWords() {
        StringBuilder contentsOfFile = new StringBuilder();
        try(FileReader fileReader = new FileReader("src/main/java/week_8/day_3/input.txt")) {
            int character;

            while ((character = fileReader.read()) != -1) {
                char c = (char) character;
                contentsOfFile.append(c);
            }

            String convertContentToString = contentsOfFile.toString();
            String[] words = convertContentToString.split("[\\s,.;!?]+");
            HashMap<String, Integer> wordFrequency = new HashMap<>();

            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            for (String word : wordFrequency.keySet()) {
                if (wordFrequency.get(word) > 1) {
                    System.out.println("Duplicate word: " + word);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        textCollectorWithUniqueness();
        convertToUpperCase();
        lineCounter();
        findDuplicatedWords();
    }
}
