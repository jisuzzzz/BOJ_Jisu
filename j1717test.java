import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class j1717test {
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        // st=new StringTokenizer(br.readLine());
        String[] str = br.readLine().split(" ");
        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        parent = new int[n+1];
        for(int i=1; i<n+1; i++){
            parent[i] = -1;
        }
        for(int i=0; i<m; i++){
            // st=new StringTokenizer(br.readLine());
            // int c = Integer.parseInt(st.nextToken());
            // int a = Integer.parseInt(st.nextToken());
            // int b = Integer.parseInt(st.nextToken());
            String[] str2 = br.readLine().split(" ");
            int c = Integer.parseInt(str2[0]);
            int a = Integer.parseInt(str2[1]);
            int b = Integer.parseInt(str2[2]);

            if(c==0){
                union(a, b);
            }
            else{
                if(a==b){
                    System.out.println("YES");
                    continue;
                }else{
                    int asr = find(a);
                    int bsr = find(b);

                    if(asr==bsr){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }

                }
            }
        }
    }
    public static int find(int v){
        if(parent[v]==-1)return v;
        parent[v]=find(parent[v]);
        return parent[v];
    }
    public static void union(int a, int b){
        int ar = find(a);
        int br = find(b);

        if(ar!=br){
            // if(ar<br){
            //     parent[br]=ar;
            // }else{
            //     parent[ar]=br;
            // }
            parent[br]=ar;
        }
    }
}
