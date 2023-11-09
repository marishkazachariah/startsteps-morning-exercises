package week_10.day_4.dependcy_injection;

public class Exercise1 {
    public static void main(String[] args) {

    }
}

interface Switchable {
    void turnOn();
    void turnOff();
}

class Light extends Switch {

    public Light(Switchable switchable) {
        super(switchable);
    }
}

class Switch {
    private final Switchable switchable;
    public Switch (Switchable switchable) {
        this.switchable = switchable;
    }
}