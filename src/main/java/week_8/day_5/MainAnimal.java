package week_8.day_5;

public class MainAnimal {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal tiger = new Mammal("Tiger", 5);
        Animal parrot = new Bird("Parrot", 3);
        Animal goldfish = new Fish("Goldfish", 1);
        Animal rattlesnake = new Reptile("Rattlesnake", 2);

        zoo.addAnimal(tiger);
        zoo.addAnimal(parrot);
        zoo.addAnimal(goldfish);
        zoo.addAnimal(rattlesnake);

        System.out.println("Unserialized animals:");
        zoo.listAnimals();


        zoo.serialize("src/main/java/week_8/day_4/zoo.ser");

        Zoo deserializedZoo = new Zoo();
        deserializedZoo.deserialize("zoo.ser");

        System.out.println("Serialized animals:");
        deserializedZoo.listAnimals();

        Animal foundAnimal = deserializedZoo.findAnimalByName("Tiger");

        if (foundAnimal != null) {
            System.out.println("Found animal: Name: " + foundAnimal.getName() + ", Sound: " + foundAnimal.sound());
        } else {
            System.out.println("Animal not found");
        }
    }
}
