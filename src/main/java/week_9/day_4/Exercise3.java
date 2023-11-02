package week_9.day_4;

enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    private final int numberOfDays;

    Month(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getDays() {
        return numberOfDays;
    }
}
public class Exercise3 {
    public static void main(String[] args) {
        Month february = Month.FEBRUARY;
        System.out.println("The amount of days in February are: " + february.getDays());
    }
}
