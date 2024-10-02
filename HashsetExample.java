import java.util.*;
public class HashsetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        System.out.println(set); // hash set is a data structure that does not allow duplicates
        System.out.println(set.contains(2));
        set.remove(2);
        
        System.out.println(set.size());
    }
    
}
