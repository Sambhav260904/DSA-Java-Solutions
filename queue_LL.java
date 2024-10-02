public class queue_LL {
    static class node
    {
        int data;
        node next;
        node(int data)
        {
            this.data=data;
            next=null;
        }
    }
    static class queue_Linkedlist
    {
        static node head=null;
        static node tail=null;
        public static boolean isempty()
        {
            return head==null && tail==null;
        }
        public static void add(int data)
        {
            node newnode= new node(data);
            if (tail==null) {
                tail= head = newnode;
                return;
            } 
            tail.next  = newnode;   
            tail = newnode;
        }
        public static void dequeue()
        {
            if (isempty()) {
                System.out.println("queue is empty");
                return;
            }
            int front = head.data;
            if (head == tail) {
                tail = null;
            }
            head= head.next;
            System.out.println("the deleted element is "+front);
        }
        public static void peek()
        {
            if (isempty()) {
                System.out.println("queue is empty");
                return;
            }
            System.out.println("the top most element is: "+head.data);
        }
    }
    public static void main(String[] args) {
     queue_Linkedlist q = new queue_Linkedlist();
     q.add(1);
     q.add(2);
     q.add(3);
     q.add(4);
     q.add(5);
     while (!q.isempty()) {
        q.peek();
        q.dequeue();
     }   
    }    
}
