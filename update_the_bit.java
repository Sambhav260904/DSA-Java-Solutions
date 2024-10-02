import java.util.*;
public class update_the_bit {
    public static void main(String[] args) {
        int res;
        int n=5;
        int  pos=2;
        int bitmask=1<<pos;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value to be updated zero or one? ");
        int value = sc.nextInt();
        if (value==0) {
            int notnumber=~(bitmask);
            res=(notnumber & n);
        }    
        else
        {
            res=(bitmask | n);
        }
        System.out.println("the updated number is : "+res);
        sc.close();
    }
}
