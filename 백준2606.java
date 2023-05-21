import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2606 {
    static int map[][];
    static boolean visit[];
    static int c,n,v;
    static int cnt;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        c = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        v=1;
        map = new int[c+1][c+1];
        visit = new boolean[c+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=map[b][a]=1;
            
        }
        br.close();
        System.out.println(DFS(1));

    }
    public static int DFS(int i){
        visit[i]=true;
        for(int j=1; j<=c; j++){
            if(map[i][j]==1 && visit[j]==false){
                System.out.println(j);
                cnt++;
                DFS(j);
            }
        }
        return cnt;
    }
}
