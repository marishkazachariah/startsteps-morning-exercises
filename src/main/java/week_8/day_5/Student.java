package week_8.day_5;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private double grade;

    public Student(int id, double grade) {
        this.id = id;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{id='" + id  + ", grade='" + grade +"'}";
    }
}

