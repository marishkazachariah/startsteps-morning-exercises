package week_8.day_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Zoo implements SerializableInterface, Serializable {
    private static final long serialVersionUID = 6L;
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge() + ", Sound: " + animal.sound());
        }
    }

    @Override
    public void serialize(Object obj, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Zoo zoo = (Zoo) ois.readObject();
            this.animals = zoo.animals;
            System.out.println("Zoo has been deserialized from " + filename);
        } catch (ClassNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}
