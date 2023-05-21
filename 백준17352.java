import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준17352 {
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i]=-1;
        }
        for(int i=0; i<n-2; i++){
            st = new StringTokenizer(br.readLine());
            int land1 = Integer.parseInt(st.nextToken());
            int land2 = Integer.parseInt(st.nextToken());

            union(land1, land2);
        }
        for(int i=2; i<=n; i++){
            if(!isSame(1, i)){
                System.out.print(1+" "+i);
                return;
            }
        }
        br.close();
    }
    public static int find(int a){
        if(parent[a]==-1)return a;
        return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b){
        int ar = find(a);
        int br = find(b);
        
        if(ar != br){
            parent[br]=ar;
        }
    }
    private static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
}
