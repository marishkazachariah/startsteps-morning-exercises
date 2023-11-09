package week_10.day_4.single_responsibility;

public class Dog {
    public static void main(String[] args) {
        DogEats dogEats = new DogEats();
        DogSound dogSound = new DogSound();

        dogEats.eat("kibble");
        dogSound.makeSound();
    }
}
