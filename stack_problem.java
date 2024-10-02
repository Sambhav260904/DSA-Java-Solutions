import java.util.*;
public class stack_problem {
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
        System.out.println(s);
        pushatbottom(4,s);
        System.out.println(s);
    }
}
