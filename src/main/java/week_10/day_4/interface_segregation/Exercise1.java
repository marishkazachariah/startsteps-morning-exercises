package week_10.day_4.interface_segregation;

public class Exercise1 {
    public static void main(String[] args) {

    }
}

class Student implements Study, Play{

    @Override
    public void study() {
        System.out.println("student studying");
    }

    @Override
    public void play() {
        System.out.println("student playing");
    }
}

class Worker implements Work, Play {

    @Override
    public void work() {
        System.out.println("working");
    }

    @Override
    public void play() {
        System.out.println("worker playing");
    }
}


interface Work {
    void work();

}

interface Study {
    void study();
}

interface Play {
    void play();
}