package week_7.day_5;

public class Main {
    public static void main(String[] args) {
        CustomStack<String> stringStack = new CustomStack<>(5);
        try {
            stringStack.push("Potato");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            stringStack.push("Tomato");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            stringStack.push("Parsley");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            stringStack.push("Corn");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            stringStack.push("Lettuce");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        // throws exception
        try {
            stringStack.push("Cereal");
        } catch (StackOverflowException exception) {
            System.out.println(exception.getMessage());
        }
        stringStack.peek();
        stringStack.pop();
        stringStack.peek();
    }
}
