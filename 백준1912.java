import java.util.Scanner;
public class 백준1912 {
    public static Integer[] dp;
    public static int[] arr;
    public static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr=new int[N];
        dp = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        dp[0]=arr[0];
        max=arr[0];

        dfsum(N-1);

        sc.close();
        System.out.println(max);
    }
    public static int dfsum(int N){
        if(dp[N]==null){
            dp[N] = Math.max(dfsum(N-1)+arr[N],arr[N]);

            max=Math.max(dp[N],max);
        }

        return dp[N];
    }

}
