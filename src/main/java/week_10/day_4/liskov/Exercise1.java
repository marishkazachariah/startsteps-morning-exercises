package week_10.day_4.liskov;

public class Exercise1 {
    public static void main(String[] args) {
        Bird penguin = new Penguin();
        Bird sparrow = new Sparrow();

        penguin.fly();
        sparrow.fly();
    }
}

abstract class Bird {
    abstract void fly();
}

class Penguin extends Bird {
    @Override
    void fly() {
        System.out.println("Penguins can't fly!");
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrows can fly!");
    }
}