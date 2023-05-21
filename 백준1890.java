import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준1890 {
	static int N;
	static int[][] box;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		box = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(DFS(1, 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long DFS(int r, int c) {
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		if (r == N && c == N) {
			return 1;
		}

		dp[r][c] = 0;

		int rr = r + box[r][c];
		int cc = c + box[r][c];

		if (rr > N && cc > N) {
			return 0;
		}

		if (rr <= N) {
			dp[r][c] = dp[r][c] + DFS(r + box[r][c], c);
		}

		if (cc <= N) {
			dp[r][c] = dp[r][c] + DFS(r, c + box[r][c]);
		}

		return dp[r][c];
	}

}



