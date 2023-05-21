import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10026 {
    static char[][] map;
    static boolean[][] visit;
    static int[] dx={0,-1,0,1};
    static int[] dy={1,0,-1,0};
    static int nocnt;
    static int yescnt;
    static int n;
    public static void DFS(int x, int y){
        visit[x][y]=true;
        char c = map[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n){
                if(map[nx][ny]==c && !visit[nx][ny]){
                    DFS(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n+1][n+1];
        visit = new boolean[n+1][n+1];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j]=str.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    DFS(i,j);
                    nocnt++;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]=='G'){
                    map[i][j]='R';
                }
            }
        }
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    DFS(i,j);
                    yescnt++;
                }
            }
        }
        System.out.println(nocnt + " " + yescnt);
    }
}
