// using hash map data structure solving below code
import java.util.*;
public class majority_element {
    public static void main(String[] args) {
        // int nums[]={1,3,2,5,1,3,1,5,1};
        int nums[]={1,2};
        HashMap<Integer,Integer> h1 = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if (!h1.containsKey(nums[i])) {
                // does not contain key pair adding it
                h1.put(nums[i], 1);
            }
            else{
              // contains key pair
                h1.put(nums[i], h1.get(nums[i]) +  1);
            }
        }
        // iteration in hash map
        // System.out.println();
        // for(Map.Entry<Integer,Integer> entry : h1.entrySet()){
        //     if (entry.getValue()>n/3) {
        //         System.out.print(entry.getKey()+" ");
        //     }
        // }
        
        for (int key : h1.keySet()) {
            if (h1.get(key) > n/3) {
                System.out.println(key);
            }
        }
}
}