public class maze_problem {
    public static int pathcount(int n,int m){
        int count=0;
        int i=0,j=0;
        if(i==n && j==m) {
            count++;
        }   
        for(;i<n;i++)
        {
            for(;j<m;j++)
            {
                pathcount(i+1, j);
                pathcount(j, i+1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n=3,m=3;
        int res= pathcount(n-1,m-1);  
        System.out.println(res);       
    }
}
