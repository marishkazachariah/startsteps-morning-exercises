package week_8.day_5;

import java.io.Serializable;

public class Reptile extends Animal implements Serializable {
    private static final long serialVersionUID = 4L;
    public Reptile(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Sssssss!";
    }
}
