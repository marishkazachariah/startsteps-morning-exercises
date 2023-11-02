package week_9.day_4;

enum Direction {
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);
    private final int deltaX;
    private final int deltaY;
    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public int calculateNewX(int currentX) {
        return currentX + deltaX;
    }

    public int calculateNewY(int currentY) {
        return currentY + deltaY;
    }
}
public class Exercise4 {
    public static void main(String[] args) {
        int startX = 0;
        int startY = 0;

        System.out.println("Starting position: (" + startX + ", " + startY + ")");

        Direction moveDirection = Direction.NORTH;
        int newX = moveDirection.calculateNewX(startX);
        int newY = moveDirection.calculateNewY(startY);
        System.out.println("Move " + moveDirection + ": (" + newX + ", " + newY + ")");

        moveDirection = Direction.EAST;
        newX = moveDirection.calculateNewX(newX);
        newY = moveDirection.calculateNewY(newY);
        System.out.println("Move " + moveDirection + ": (" + newX + ", " + newY + ")");
    }
}
