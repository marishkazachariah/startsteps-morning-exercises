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

    @Serial
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        String encryptedName = reverse(encrypt(name));
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(encryptedName);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String encryptedName = (String) in.readObject();
        name = decrypt(reverse(encryptedName));
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Googled this
    private String encrypt(String data) {
        byte[] encryptedBytes = data.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decrypt(String encryptedData) {
        byte[] decryptedBytes = Base64.getDecoder().decode(encryptedData);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
