package week_8.day_4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

public class Person implements Serializable {
    private String name;
    private int age;
    private String address;
    private final transient LocalDateTime currentDateTime;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.currentDateTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    // Exercise 5
    @Serial
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(encrypt(name));
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        name = decrypt((String) in.readObject());
    }

    // Googled this
    private String encrypt(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    private String decrypt(String encryptedData) {
        return new StringBuilder(encryptedData).reverse().toString();
    }
}
