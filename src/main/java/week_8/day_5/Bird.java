package week_8.day_5;

class Bird extends Animal {
    private static final long serialVersionUID = 2L;
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    String sound() {
        return "Caw!";
    }
}
