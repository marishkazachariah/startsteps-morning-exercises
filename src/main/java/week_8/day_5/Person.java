package week_8.day_5;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person={name='" + name  + ", age='" + age + ", salary='" + salary +"'}";
    }
}
