public class circular_queue {    
        static class queue
        {
            static int arr[];
            static int size;
            static int rear = -1;
            static int front =  -1;
            queue(int n)
            {
                arr = new int[n];
                this.size=n;
            }
            public static boolean isempty()
            {
                return rear==-1 && front==-1;
            }
            public static boolean isfull()
            {
                return (rear+1)%size == front;
            }
            public static void add(int data)
            {
                if (isfull()) {
                    System.out.println("queue is full");
                    return;
                }
                if (front==-1) {
                    front=0;
                }
                rear=(rear+1) % size;
                arr[rear]=data;
            }
            public static void dequeue()
            {
                if (isempty()) {
                    System.out.println("queue is empty");
                    return;
                }
                int res=arr[front];
                if (rear == front) {
                    rear=front=-1;
                }
                else
                {
                    front=(front+1)%size;
                }
                System.out.println("the deleted element is "+res);            
            }
            public static void peek()
            {
                if (isempty()) {
                    System.out.println("queue is empty");
                    return;
                }
                System.out.println("the top element in the  queue "+arr[front]);
            }
        }
        public static void main(String[] args) {
            queue q = new queue(5);
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
