import java.util.Scanner;

public class 백준1309 {
    public static long[][] dp;
    public static int N;
    public static void main(String[] args){
        final int k=9901;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp=new long[N+1][3];
        dp[1][0]=dp[1][1]=dp[1][2]=1;

        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%k;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%k;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%k;
        }
        long result = (dp[N][0]+dp[N][1]+dp[N][2])%k;
        System.out.println(result);

        

        sc.close();
    }

}
