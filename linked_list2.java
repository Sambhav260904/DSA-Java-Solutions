import java.util.*;
public class linked_list2 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.add(12);
        l1.add(17);
        l1.add(13);
        l1.addFirst(21);
        l1.addLast(444);
        
        System.out.println(l1.getClass());
        System.out.println(l1);

        System.out.println(l1.size());
    }
    
}
