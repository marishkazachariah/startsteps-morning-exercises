package week_8.day_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Mary", 30, 60000);
        serialize(person, "src/main/java/week_8/day_5/person.ser");
        Person deserializedPerson = (Person) deserialize("src/main/java/week_8/day_5/person.ser");
        System.out.println(deserializedPerson);


        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, 3.2));
        students.add(new Student(2, 3.8));
        students.add(new Student(3, 2.2));
        students.add(new Student(4, 4.0));

        serialize(students, "src/main/java/week_8/day_5/students.ser");
        List<?> deserializeStudents = (List<?>) deserialize("src/main/java/week_8/day_5/students.ser");
        for (Object student : deserializeStudents) {
            System.out.println(student);
        }
    }

    public static void serialize(Object obj, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String filename) throws ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
