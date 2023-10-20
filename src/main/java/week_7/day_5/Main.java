package week_7.day_5;

public class Main {
    public static void main(String[] args) {
        CustomStack<String> stringStack = new CustomStack<>(5);
        stringStack.push("Potato");
        stringStack.push("Tomato");
        stringStack.push("Parsley");
        stringStack.push("Corn");
        stringStack.push("Lettuce");
        stringStack.push("Cereal");

        stringStack.peek();
        stringStack.pop();
        stringStack.peek();
        System.out.println(stringStack.size());
        System.out.println(stringStack);
        // with custom exception thrown
//        try {
//            stringStack.push("Potato");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        try {
//            stringStack.push("Tomato");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        try {
//            stringStack.push("Parsley");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        try {
//            stringStack.push("Corn");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        try {
//            stringStack.push("Lettuce");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        // throws exception
//        try {
//            stringStack.push("Cereal");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
//        try {
//            stringStack.push("Cooking oil");
//        } catch (StackOverflowException exception) {
//            System.out.println(exception.getMessage());
//        }
    }
}
