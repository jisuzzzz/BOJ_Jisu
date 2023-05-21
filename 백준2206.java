import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준2206 {
    static class Loc{
        int x;
        int y;
        int cnt;
        int crush;
        public Loc(int x, int y, int cnt, int crush){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.crush=crush;
        }
    }
    static int[][] map;
    static int[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int n,m,ans;

    static void BFS(int y, int x, int cnt, int crush){
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(y, x, 1, 0));
        visit[y][x]=0;
            while(!q.isEmpty()){
                Loc now = q.poll();
                if(now.y==n-1 && now.x==m-1){
                    ans = now.cnt;
                    break;
                }
                for(int i=0; i<4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    
                    if(nx<0 || ny <0 || ny>=n || nx>=m) continue;
                    if(visit[ny][nx] <= now.crush) continue;
                    if(map[ny][nx]==0){
                        visit[ny][nx]=now.crush;
                        q.add(new Loc(nx, ny, now.cnt+1, now.crush));
                    }
                    else{
                        if(now.crush==0){
                            visit[ny][nx]=now.crush+1;
                            q.add(new Loc(nx, ny, now.cnt+1, now.crush+1));
                        }
                    }
                    
                }
            }
        }
    

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        visit = new int[n][m];
        for(int i=0; i<n; i++){
            String str2 = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j]=str2.charAt(j)-'0';
                visit[i][j]=Integer.MAX_VALUE;
            }
        }
        ans = Integer.MAX_VALUE;
        BFS(0,0,0,0);
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}