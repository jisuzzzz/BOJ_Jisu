import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11724{
    static int parent[];
    static int cnt=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i]=-1;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        for(int i=1; i<n+1; i++){
            if(parent[i]==-1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static int find(int x){
        if(parent[x]==-1) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        int xr = find(x);
        int yr = find(y);

        if(xr != yr){
            if(xr<yr){
                parent[yr]=xr;
            }
            else{
                parent[xr]=yr;
            }
        }
    
    }
}