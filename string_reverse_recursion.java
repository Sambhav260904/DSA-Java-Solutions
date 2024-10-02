public class string_reverse_recursion {
    public static void reverse_string(String s,int n)
    {
        if (n<0) {
            return;
        }
        System.out.print(s.charAt(n));
        reverse_string(s, n-1);
    }
    public static void main(String[] args) {
        String name= "abaavvajgljhj";
        int length=name.length();
        reverse_string(name,length-1);
    }    
}
