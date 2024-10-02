public class queue_dsa {
    static class queue
    {
        static int arr[];
        static int size;
        static int rear =-1;
        queue(int size)
        {
            arr = new int[size];
            this.size=size;
        }
        public static boolean isempty()
        {
            return rear==-1;
        }
        public static void add(int data)
        {
            if (rear==size-1) {
                System.out.println("queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        public static void dequeue()
        {
            if (isempty()) {
                System.out.println("queue is empty");
                return;
            }
            int front =arr[0];
            for(int i=0;i<rear;i++)
            {
                arr[i]=arr[i+1];
            }
            rear--;
            System.out.println("the deleted element is "+front);            
        }
        public static void peek()
        {
            if (isempty()) {
                System.out.println("queue is empty");
                return;
            }
            System.out.println("the top element in the  queue "+arr[0]);
        }
    }
    public static void main(String[] args) {
        queue q = new queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isempty()) {
            q.peek();
            q.dequeue();
        }
    }
}