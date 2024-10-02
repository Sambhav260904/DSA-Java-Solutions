class validpalindrome {
    public static  boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)==' ' || s.charAt(start)==','|| s.charAt(start)==':'){
                start++;
                continue;
            }
            if(s.charAt(end)==' ' || s.charAt(end)==','|| s.charAt(end)==':'){
                end--;
                continue;
            }
            
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
}
public static void main(String[] args) {
System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
}
}
