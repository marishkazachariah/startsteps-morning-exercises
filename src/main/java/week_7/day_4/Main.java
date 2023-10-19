package week_7.day_4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    // 2. Write a Java program to count the number of key-value (size) mappings in a map.
    public static<K, V> int countOfKeyValueSize(Map<K, V> map) {
        return map.size();
    }

    // 3. Write a Java program to copy all mappings from the specified map to another map.
    public static<K, V> Map<K,V> copyToMap(Map<K, V> map) {
        Map<K,V> copyOfMap = map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));
        copyOfMap.forEach((key, value) -> System.out.println("key:" + key + " value: " + value));
        return copyOfMap;
    }

    // 4. Write a Java program to remove all mappings from a map.
    public static<K,V> Map<K,V> removeElementsFromAMap(Map<K, V> map) {
        map.clear();
        return map;
    }

    // 5. Write a Java program to check whether a map contains key-value mappings (empty) or not.
    public static<K,V> boolean isMapEmpty(Map<K, V> map) {
        return map.isEmpty();
    }

    // 6. Shallow copy
    public static<K,V> Map<K,V> createShallowCopyOfMap(Map<K, V> map) {
        map.clear();
        return map;
    }

    public static void main(String[] args) {
        // 1.
        HashMap<Integer, String> hashMapOfFood = new HashMap<Integer, String>();
        hashMapOfFood.put(1, "potato");
        hashMapOfFood.put(2, "tomato");
        hashMapOfFood.put(3, "parsley");
        hashMapOfFood.put(4, "salmon");

        for(Map.Entry entry: hashMapOfFood.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        // 2.
        System.out.println("Count of key-value mappings: " + countOfKeyValueSize(hashMapOfFood));

        // 3.
        System.out.println("copy of original map: " + copyToMap(hashMapOfFood));

        // 4.
        System.out.println(removeElementsFromAMap(hashMapOfFood));
    }

}
