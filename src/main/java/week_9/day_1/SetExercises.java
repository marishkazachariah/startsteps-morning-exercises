package week_9.day_1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExercises {
    public static void main(String[] args) {
        // Exercise 1
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(2);
        integerSet.add(5);
        integerSet.add(6);
        System.out.println(integerSet);

        // Exercise 2
        Set<String> uniqueStrings = new HashSet<>();
        String[] words = {"apple", "banana", "apple", "cherry"};
        for (String word: words) {
            uniqueStrings.add(word);
        }
        System.out.println("unique strings: " + uniqueStrings);

        // Exercise 3
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(12);
        sortedSet.add(2);
        sortedSet.add(24);
        sortedSet.add(5);

        for (Integer number : sortedSet) {
            System.out.println(number);
        }

        // Exercise 4 - Sorting Set by age
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("Mindy", 23));
        personSet.add(new Person("Mork", 4));
        personSet.add(new Person("Jane", 12));
        personSet.add(new Person("Cindy", 32));

        for(Person person: personSet) {
            System.out.println("Person: " + person.getName() + " Age: " + person.getAge());
        }

        // Exercise 5
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        setA.add(12);
        setA.add(2);
        setA.add(24);
        setA.add(5);

        setB.add(12);
        setB.add(34);
        setB.add(24);
        setB.add(5);
        setB.add(6);

        System.out.println("union:");
        setA.addAll(setB);
        for (Integer number : setA) {
            System.out.println(number);
        }

        System.out.println("intersection");
        setA.retainAll(setB);
        for (Integer number : setA) {
            System.out.println(number);
        }

        System.out.println("difference");
        setA.removeAll(setB);
        for (Integer number : setA) {
            System.out.println(number);
        }
    }
}
