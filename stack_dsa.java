//stack using linked_list
public class stack_dsa {
    public static class node
    {
        int data;
        node next;
        node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
  static node head=null;
  public static class stack
    {
        static boolean isempty()
        {
            return head==null;
        }
        public static void push(int data)
        {
            node newnode = new node(data);
            if (isempty()) {
                head=newnode;
                return;
            }
            newnode.next=head;
            head=newnode;
        }
        static void pop()
        {
            if (isempty()) {
                System.out.println("the stack is empty");
                return;
            }
            System.out.println("the popped element is "+head.data);
            head=head.next;
        }
        static int peek()
        {
            if (isempty()) {
                System.out.println("the stack is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isempty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}