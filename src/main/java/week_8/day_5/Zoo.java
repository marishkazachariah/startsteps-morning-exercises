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
    public void serialize(String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(this);
            System.out.println("Zoo has been serialized to " + filename);
        } catch (IOException e) {
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
            System.out.println("File not found" + e.getMessage());
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
