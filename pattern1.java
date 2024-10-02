public class pattern1{
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Print 1 if the sum of i and j is odd, else print 0
                if ((i + j) % 2 == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}