 import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // Add key-value pairs to the Hashtable
        hashtable.put("Apple", 10);
        hashtable.put("Banana", 20);
        hashtable.put("Orange", 30);
        hashtable.put("Mango", 40);

        // Display the Hashtable
        System.out.println("Hashtable: " + hashtable);

        // Retrieve a value using a key
        int value = hashtable.get("Banana");
        System.out.println("Value for 'Banana': " + value);

        // Remove a key-value pair
        hashtable.remove("Apple");
        System.out.println("After removing 'Apple': " + hashtable);

        // Check if a key exists
        boolean containsKey = hashtable.containsKey("Orange");
        System.out.println("Contains 'Orange': " + containsKey);

        // Check if a value exists
        boolean containsValue = hashtable.containsValue(40);
        System.out.println("Contains value 40: " + containsValue);
        String ans =hashtable.getClass().getName();
        System.out.println(ans);
    }
}
 
