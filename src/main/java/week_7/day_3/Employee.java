package week_7.day_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{age=" + age + " Name=" + name + "}";
    }
}