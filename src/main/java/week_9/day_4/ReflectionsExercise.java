package week_9.day_4;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;

    }

    public String getName() {
        return name;
    }
}
public class ReflectionsExercise {
    public static void main(String[] args) {
        try {
            // Get the Person class
            Class<?> personClass = Class.forName("Person");

            // 1. Get and print the class name of the Person class
            String className = personClass.getName();
            System.out.println("Class Name: " + className);

            // 2. Retrieve and print the names and types of all fields in the Person class
            Field[] fields = personClass.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                String fieldName = field.getName();
                String fieldType = field.getType().getName();
                System.out.println(fieldName + " (" + fieldType + ")");
            }

            // 3. Retrieve and print the names of all methods in the Person class
            Method[] methods = personClass.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            // 4. Create an instance of the Person class and invoke the public method to get the name
            Person person = new Person("John Doe", 30, "New York");
            Method getNameMethod = personClass.getMethod("getName");
            String personName = (String) getNameMethod.invoke(person);
            System.out.println("\nPerson's Name: " + personName);
        } catch (ClassNotFoundException e) {
            System.out.println("Person class not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

