    // REMOVE THE DUPLICATES FROM A STRING using recursion
public class remove_duplicates {
    public static boolean map[] = new boolean[26]; 
    public static void remove_duplicates(String s,int i,String newString){
        if (i==s.length()) {
            System.out.println(newString);
            return;
        }
        char currchar=s.charAt(i);
        if (map[currchar - 'a']==true) {
            remove_duplicates(s, i+1, newString);            
        }
        else
        {
            newString+=currchar;
            map[currchar-'a']=true;
            remove_duplicates(s, i+1, newString);
        }
    }
    public static void main(String[] args) {
        String str = "abcaaghdtde";
        remove_duplicates(str,0,"");
    }
    
}
