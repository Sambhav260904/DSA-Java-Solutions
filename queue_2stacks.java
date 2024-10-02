// queue using two stacks
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queue_2stacks {
    static class queue{
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();
        public static boolean isempty()
        {
            return s1.isEmpty();
        }
        public static void Enqueue(int data)
        {
            if (s1.isEmpty()) {
                s1.push(data);
                return;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public static void Dequeue()
        {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return;
            }
            System.out.println("the popped element is : "+ s1.pop());
        }
        public static void peek()
        {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return;
            }
            System.out.println("the top most element is : "+s1.peek());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(22);
        q.add(33);
        q.add(44);
        q.add(55);
        System.out.println("the elements in the queue using two stacks are: ");
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
