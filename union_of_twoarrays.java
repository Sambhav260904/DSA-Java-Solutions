// using hash set data structure solving below code
import java.util.*;
public class union_of_twoarrays {
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={3,4,5,6,7};
        HashSet<Integer> set = new HashSet<>();
        int m=arr1.length,n=arr2.length;
        int size = m>n ? m:n;
        for(int i=0;i<size;i++)
        {
            if (i<m) {
                set.add(arr1[i]);
            }
            if (i<n) {
                set.add(arr2[i]);
            }
        }
        System.out.println(set);
    }
}