// from apna college you tube- dsa with java playlist(lecture-15)
public class clearbit_binary {
    public static void main(String[] args) {
        int n=5;
        int pos=2;
        int bitmask=1<<pos;
        int notbit=~(bitmask);
        int res=(notbit & n);
        System.out.println(res);
    }
}
