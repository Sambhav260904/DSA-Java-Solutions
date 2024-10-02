import java.util.*;
public class IteratorExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(21);
        set.add(2);
        set.add(3);
        set.add(0);
        Iterator<Integer> i1=set.iterator();
        // iterator has two methods next() and hasNext()
        while(i1.hasNext())
        {
            System.out.println(i1.next());
        }
    }
    
}
