package week_8.day_5;

public class Fish extends Animal{
    private static final long serialVersionUID = 5L;
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Bloop!";
    }
}
