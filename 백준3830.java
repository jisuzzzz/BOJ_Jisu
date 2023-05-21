import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준3830{
    static int[] parent;
    static long[] weight;
    static int N,M;
    static String Q;
    static int a, b, w;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0)break;
            parent = new int[N+1];
            for(int j=1; j<N+1; j++){
                parent[j]=-1;
            }
            weight = new long[N+1];
            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                Q = st.nextToken();
                
                if(Q.equals("!")){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    w = Integer.parseInt(st.nextToken());
                    union(a,b,w);
                }
                else if(Q.equals("?")){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());

                    if(find(a) != find(b)){
                        System.out.println("UNKNOWN");
                    } 
                    else {
                        System.out.println(weight[b]-weight[a]);
                    }
                }
            }
            for(int i=1; i<N+1; i++){
                System.out.println(weight[i]);
            }
        }
        br.close();
    }
    public static int find(int a){
        if(parent[a]==-1)return a;
        int tmep = find(parent[a]);
        weight[a]+=weight[parent[a]]; 
        return parent[a]=tmep;
    }
    public static void union(int a, int b, long w){
        int ar = find(a); 
        int br = find(b); 
        if(ar==br)return;
        else{
            parent[br]=ar;
            weight[br]+=w-weight[b]+weight[a]; 
        }
    }
}