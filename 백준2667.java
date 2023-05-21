import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 백준2667 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int cnt;

    public static void DFS(int x, int y){
        visit[x][y]=true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(map[nx][ny]==1 && !visit[nx][ny]){
                    DFS(nx, ny);
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !visit[i][j]){
                    cnt=1;
                    DFS(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int c : list) System.out.println(c);
    }
}
