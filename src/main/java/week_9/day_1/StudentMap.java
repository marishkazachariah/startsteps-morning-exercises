package week_9.day_1;

import java.util.*;

public class StudentMap {
    public static void main(String[] args) {
        // Exercise 1
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Katie");
        students.put(3, "Joe");
        students.put(2, "Jack");
        System.out.println("Student: " + students.get(2));

        // Exercise 2
        for(Map.Entry<Integer,String> student : students.entrySet()) {
            int id = student.getKey();
            String name = student.getValue();
            System.out.println("key: " + id + " value: " + name);
        }

        // Exercise 3
        Map<String, String> capitalMap = new LinkedHashMap<>();
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("France", "Paris");
        capitalMap.put("India", "New Dehli");

        for(Map.Entry<String, String> c : capitalMap.entrySet()) {
            String country = c.getKey();
            String city = c.getValue();
            System.out.println("key: " + country + " value: " + city);
        }

        // Exercise 4
        students.remove(3);
        System.out.println("Is Student removed: " + students.get(3));

        // Exercise 5
        String text = "This is a sample text. This text is used for counting word frequencies.";
        String[] words = text.split(" ");
        List<String> arrListWords = new ArrayList<>();
        Map<String, Integer> frequencyOfWords = new HashMap<>();

        for (String word: words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            arrListWords.add(word);
        }

        for (String word: arrListWords) {
            frequencyOfWords.putIfAbsent(word, Collections.frequency(arrListWords, word));
        }

        for(Map.Entry<String, Integer> wordFreq : frequencyOfWords.entrySet()) {
            System.out.println("KEY: " + wordFreq.getKey() + " VALUE: " + wordFreq.getValue());
        }
    }
}
