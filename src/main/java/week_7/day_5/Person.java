package week_7.day_5;

import java.util.Collections;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Compare the current instance (this) to the other instance
        // Return a negative value if this is less than other,
        // 0 if they are equal, and a positive value if this is greater than the other.
        if(this.name.equalsIgnoreCase(otherPerson.name)) {
            return 0;
        } else if(this.name.charAt(0) < otherPerson.name.charAt(0)) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age;
    }
}
