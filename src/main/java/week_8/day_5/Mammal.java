package week_8.day_5;

public class Mammal extends Animal{
    private static final long serialVersionUID = 3L;
    public Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Roar!";
    }
}
