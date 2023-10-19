package week_7.day_3;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/*
Exercise 1.
Objective: Imagine you have a list of integer numbers. Your task is to filter out all even numbers from this list and create a new list containing only the odd numbers.
Expected Outcome: Given a list like [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], your output should be [1, 3, 5, 7, 9].
Bonus: Return the sum of the filtered odd numbers.

Exercise 2.
Objective: You are given a list of words in lowercase. Your challenge is to transform each word into its uppercase counterpart.
Expected Outcome: Given a list like ["hello", "world", "streams", "java"], the transformed list should be ["HELLO", "WORLD", "STREAMS", "JAVA"].
Bonus: Count the number of characters in the transformed list (excluding spaces).

Exercise 3.
Objective: You have a list of integers. Calculate the sum of all these integers.
Expected Outcome: Given a list like [1, 2, 3, 4, 5], the computed sum should be 15.
Bonus: Find the average of the list.

Exercise 4.
Objective: Join all strings from a given list into a single string. These words should be separated by commas in the resulting string.
Expected Outcome: From a list such as ["apple", "banana", "cherry"], the resulting string should be "apple,banana,cherry".
Bonus: Reverse the order of the words in the resulting string. So, for the list ["apple", "banana", "cherry"], the resulting string would be "cherry,banana,apple".

Exercise 5.
Objective: Given a list of words, count how many words have more than 3 characters.
Expected Outcome: For a list like ["cat", "elephant", "dog", "dolphin"], the count should be 2 since "elephant" and "dolphin" have more than 3 characters.
Bonus: Return the shortest word from the list.
 */

public class Main {

    public static int filterNumbers(List<Integer> numbers) {
        return numbers.stream().filter(e -> e % 2 != 0).toList().stream().reduce(0, (acc, el) -> acc + el);
    }

    public static List<String> convertToUpperCase(List<String> words) {
        return words.stream().map(String::toUpperCase).toList();
    }

    public static int sumOfIntegers(List<Integer> numbers) {
        // alternative with Lambda sum
        // return numbers.stream().reduce(0, Integer::sum);
        return numbers.stream().reduce(0, (acc, el) -> acc + el);
    }

    // couldn't figure out bonus for 4. (without google/chatgpt)
    public static String joinStrings(List<String> words) {
        // initial idea
        // return words.stream().reduce("", (acc, el) -> acc + "," + el);
        return words.stream().collect(Collectors.joining(","));
    }

    public static long howManyWords(List<String> words) {
        return words.stream().filter(word -> word.length() > 3).count();
    }


    // BONUS

    public static int bonusConvertToUpperCase(List<String> words) {
        return words.stream().map(String::toUpperCase).mapToInt(word -> word.replaceAll("\\s", "").length()).sum();
    }

    public static int bonusSumOfIntegers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (acc, el) -> acc + el) / numbers.size();
    }


    public static String bonusHowManyWords(List<String> words) {
        return String.valueOf(words.stream().min((word1, word2) -> Integer.compare(word1.length(), word2.length())));
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static void main(String[] args) {
        // Afternoon exercises
        String source = "Hello, World!";
        UnaryOperator<String> everySecondChar = str -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(str.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String modifiedString = everySecondChar.apply(source);
        System.out.println("lambda: " + modifiedString);
        System.out.println(everySecondChar(source));

        // Morning Exercises
        // 1 (+ Bonus)
        List<Integer> numbers = Arrays.asList(3, 4, 5, 2, 10, 6);
        System.out.println(filterNumbers(numbers));


        // 2
        List<String> words = Arrays.asList("mto", "erwew", "goose");
        System.out.println(convertToUpperCase(words));

        // 3
        System.out.println(sumOfIntegers(numbers));

        // 4
        System.out.println(joinStrings(words));

        // 5
        System.out.println(howManyWords(words));

        // BONUSES
        System.out.println(bonusConvertToUpperCase(words));

        System.out.println(bonusSumOfIntegers(numbers));

        System.out.println(bonusHowManyWords(words));


    }
}