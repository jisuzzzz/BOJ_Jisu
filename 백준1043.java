import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준1043 {
    static int N;
    static int[] truth_p;
    static int[] parent;
    static List<int[]> party_list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truth_n = Integer.parseInt(st.nextToken());
        if (truth_n == 0) {
            System.out.println(M);
            return;
        }
        else{
            truth_p = new int[truth_n];
            for (int i = 0; i < truth_n; i++) {
                truth_p[i] = Integer.parseInt(st.nextToken());
            }

            parent = new int[N+1];
            init();
            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int party_n = Integer.parseInt(st.nextToken());
                if (party_n == 0) {
                    party_list.add(new int[]{});
                    continue;
                }
                int[] tmp = new int[party_n];
                int val = Integer.parseInt(st.nextToken());
                tmp[0] = val;
                for (int j = 1; j < party_n; j++){
                    int item = Integer.parseInt(st.nextToken());
                    tmp[j] = item;
                    if (val < tmp[j]) union(val, item);
                    else union(item, val);
                }
                party_list.add(tmp);
            }
            int ans = 0;

            for (int[] tmp : party_list){
                boolean flag = false;
                for (int item : tmp){
                    if (!check(item)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) ans++;
            }
            System.out.println(ans);
        }

    }
    static public void init(){
        for (int i = 1; i <= N; i++){
            parent[i] = -1;
        }
    }
    static public int find(int x){
        if (parent[x]==-1) return x;
        else return parent[x] = find(parent[x]);
    }
    static public void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
    static public boolean check(int x){
        x = find(x);
        for (int item : truth_p){
            if (x == find(item)) return false;
        }
        return true;
    }
}