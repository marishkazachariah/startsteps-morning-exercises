package week_9.day_4;
enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public DayOfWeek getNextDay() {
        return switch (this) {
            case SUNDAY -> MONDAY;
            case MONDAY -> TUESDAY;
            case TUESDAY -> WEDNESDAY;
            case WEDNESDAY -> THURSDAY;
            case THURSDAY -> FRIDAY;
            case FRIDAY -> SATURDAY;
            case SATURDAY -> SUNDAY;
        };
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        DayOfWeek currentDay = DayOfWeek.TUESDAY;
        DayOfWeek nextDay = currentDay.getNextDay();
        System.out.println("Next day after " + currentDay + " is " + nextDay);
    }
}
