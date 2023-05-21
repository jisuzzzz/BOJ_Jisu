import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1717 {
    public static int find(int u, int[] parent){
        
        if(parent[u]==-1) return u;
        int v =u;
        while(parent[u]!=-1){
            u=parent[u];
        }
        int p;
        while(parent[v]!=u){
            p=parent[v];
            parent[v]=u;
            v=p;
        }
        return u;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = -1;
        }

        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int u = Integer.parseInt(st2.nextToken());

            
            if(c==0){
                int ur = find(u,parent);
                int vr = find(v,parent);
                
                if(ur!=vr){
                    parent[vr]=ur;
                }
                
            }
            else{
                if(u==v){
                    System.out.println("YES");
                    continue;
                }
                int ur = find(u,parent);
                int vr = find(v,parent);

                if(ur==vr){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
        for(int i=0; i<m+1; i++){
            System.out.println(parent[i]);
        }
        br.close();
    }
}
