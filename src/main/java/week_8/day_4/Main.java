package week_8.day_4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Exercise 1 and 2
        // Serialization
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/week_8/day_4/person.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Person person = new Person("Loki", 34, "33 State Drive");
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialization
        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/week_8/day_4/person.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person personObj = (Person) objectInputStream.readObject();
            if (personObj != null) {
                System.out.println("Person's name: " + personObj.getName()
                        + " Person's age: " + personObj.getAge()
                        + " Person's address: " + personObj.getAddress()
                        + " Current date and time: " + personObj.getCurrentDateTime()); // prints null
            }
        } catch (InvalidClassException e) {
            System.err.println("InvalidClassException: The class structure has changed during deserialization.");
        }  catch (Exception e) {
            e.printStackTrace();
        }

        // Exercise 3
        // Serialization
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/week_8/day_4/vehicle.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Vehicle vehicle = new Vehicle("Toyota", "Camry", 2000);
            objectOutputStream.writeObject(vehicle);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialization
        Vehicle vehicleObj = null;

        try (FileInputStream fileInputStream = new FileInputStream("src/main/java/week_8/day_4/vehicle.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            vehicleObj = (Vehicle) objectInputStream.readObject();

            if (vehicleObj != null) {
                System.out.println("Deserialized Vehicle:");
                System.out.println("Make: " + vehicleObj.getMake());
                System.out.println("Model: " + vehicleObj.getModel());
                System.out.println("Year: " + vehicleObj.getYear());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
