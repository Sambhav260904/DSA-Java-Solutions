import java.util.*;
public class iteration_in_hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> h1 = new HashMap<>();
        h1.put("sambhav", 01);
        h1.put("sam altman", 02);
        h1.put("ram", 03);
        h1.put("sambhav", 04);
        // for each loop
        for(Map.Entry<String,Integer> entry:h1.entrySet())
        {
            // printing key and value
            System.out.println(entry.getKey()+" "+entry.getValue());  
            //System.out.println(entry);
        }       
    }
}
