package week_8.day_5;

import java.io.Serializable;

public class Mammal extends Animal implements Serializable {
    private static final long serialVersionUID = 3L;
    public Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Roar!";
    }
}
