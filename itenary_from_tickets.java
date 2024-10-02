import java.util.HashMap;

public class itenary_from_tickets {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("bombay", "delhi");
        map.put("delhi", "goa");
        map.put("goa", "chennai");
        map.put("chennai", "bengaluru");
        // String start = "mumbai";
        // String end = "bengaluru";
        for (String s : map.keySet()) {
            if (!map.containsValue(s)) {
                String start = s;
                while (map.containsKey(start)) {
                    System.out.print(start + "->");
                    start = map.get(start);

                }
                System.out.print(start);
                break;
            }
        }
    }
}
