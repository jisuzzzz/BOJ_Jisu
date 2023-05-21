import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1976 {
    static int[] parent;
    public static void main(String[] args)throws NumberFormatException,IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int plan = find(Integer.parseInt(st.nextToken()));
        for(int i=0; i<m-1; i++){
            int now = Integer.parseInt(st.nextToken());
            if(plan!=find(now)){
                System.out.println("NO");
                break;
            }
        }
        System.out.println("Yes");
        br.close();
    }
    public static int find(int u){
        if(u==parent[u])return u;
        return parent[u] = find(parent[u]);
    }
    public static void union(int x, int y){
        int xr=find(x);
        int yr=find(y);
        if(xr!=yr){
            if(xr<yr){
                parent[yr]=xr;
            }else{
                parent[xr]=yr;
            }
        }
    }
}
