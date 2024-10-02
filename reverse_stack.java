import java.util.Stack;
public class reverse_stack {
    public static void reversethestack(Stack<Integer> s)
    {
        if (s.empty()) {
            return;
        }
        int i= s.pop();
        reversethestack(s);
        pushatbottom(i, s);
    }
    public static void pushatbottom(int data,Stack<Integer> s)
    {
        if (s.empty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatbottom(data, s);
        s.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        reversethestack(s);
        System.out.println(s);
    }    
}
