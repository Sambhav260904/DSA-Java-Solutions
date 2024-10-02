// permutations of the string
public class permutation_string {
    public static void permu(String s,String permutation)
    {
        if (s.length()==0) {
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            char currchar = s.charAt(i);
            String newsString = s.substring(0, i) + s.substring(i+1);
            
            permu( newsString , permutation+ currchar);
        }
    }
    public static void main(String[] args) {
    String str =  "abcd";    
    permu(str,"");
}    
}
