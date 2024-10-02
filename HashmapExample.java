// hash map contains 
import java.util.*;
public class HashmapExample {
    public static void main(String[] args) {
        HashMap<String,Integer> h1 = new HashMap<>();
        
        // insertion of key and value pair in hash map
        h1.put("sambhav", 12);
        h1.put("ram", 17);
        h1.put("sam", 13);
        System.out.println(h1);
        // search operation in hash map or look up operation in hash map
        System.out.println(h1.containsKey("sambhav"));
        System.out.println(h1.containsValue(17));
        System.out.println(h1.get("sambhav"));
        // deletion operation in hash map
        h1.remove("sambhav");
        System.out.println(h1);
        // size of hash map
        System.out.println(h1.size());
        // clear the hash map
        h1.clear();
        System.out.println(h1);
        // hash code 
        //System.out.println(h1.hashCode());
    }
}
