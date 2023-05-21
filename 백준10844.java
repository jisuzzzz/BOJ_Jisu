import java.util.Scanner;
public class 백준10844 {
    static Long[][] dp;
    static int N;
    final static long a =1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Long[N+1][10];
        
        for(int i=0; i<10; i++){
            dp[1][i]=1L;
        }
        long result = 0;

        sc.close();

        for(int i=1; i<=9; i++){
            result += df(N,i);
        }

        System.out.println(result%a);
    }
    static long df(int M, int val){
        if(M==1){
            return dp[M][val];
        }

        if(dp[M][val]==null){
            if(val==0){
                dp[M][val]=df(M-1,1);
            }
            else if(val==9){
                dp[M][val]=df(M-1,8);
            }
            else{
                dp[M][val]=df(M-1,val-1)+df(M-1,val+1);
            }
        }
        return dp[M][val]%a;


    }
}
