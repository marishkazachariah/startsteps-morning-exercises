package week_8.day_5;

import java.io.Serializable;

public class Fish extends Animal implements Serializable {
    private static final long serialVersionUID = 5L;
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Bloop!";
    }
}
