// abc
import java.util.HashSet;
// import java.util.Scanner;
public class string_subsequences {
    public static void printsubsequences(String s,int i,String newString,HashSet<String> set)
    {
        if (i==s.length()) {
            if (set.contains(newString)) {
                return;
            }
            else{
            set.add(newString);
            System.out.println(newString);
            return;
            }
        }
        char ch = s.charAt(i);
        printsubsequences(s, i+1, newString+ch,set);
        printsubsequences(s, i+1, newString,set);
    }
    public static void main(String[] args) {
      String str = "aaa";
      HashSet<String> set= new HashSet<>(26);  
      printsubsequences(str,0,"",set);  
    }    
}

