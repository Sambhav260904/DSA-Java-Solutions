
import java.util.PriorityQueue;

public class priority_queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(220);
        pq.add(20);
        pq.add(30);
        pq.add(10);
        pq.add(1);
        pq.add(25);
        pq.add(5);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
            // pq.remove();
        }
    }
}
