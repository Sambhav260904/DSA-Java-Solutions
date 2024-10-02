// from apna college you tube- dsa with java playlist(lecture-15)
public class getbit_frombits {
    public static void main(String[] args) {
        int n=5;
        int pos=3;
        int bitmask=1<<pos;
        if((bitmask & n)!=0)
        {
            System.out.println("1");
        }        
        else
        {
            System.out.println("0");
        }
    }    
}
