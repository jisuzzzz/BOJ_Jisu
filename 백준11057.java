import java.util.Scanner;

public class 백준11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] dp = new long[N+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        sc.close();

        System.out.println(result % 10007);
    }
}
