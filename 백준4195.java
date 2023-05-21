import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준4195 {
    static int[] parent;
    static int[] cnt;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int F = Integer.parseInt(br.readLine());
            parent = new int[F*2];
            cnt = new int[F*2];
            for(int i=0; i<F*2; i++){
                parent[i]=-1;
            }
            Arrays.fill(cnt, 1);
            HashMap<String, Integer> hm = new HashMap<>();
            int index=0;
            while(F-->0){
                st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                if(!hm.containsKey(f1)){
                    hm.put(f1,index++);
                }
                if(!hm.containsKey(f2)){
                    hm.put(f2,index++);
                }
                System.out.println(union(hm.get(f1), hm.get(f2)));

            }
        }

    }
    public static int find(int a){
        if(parent[a]==-1)return a;
        parent[a]=find(parent[a]);
        return parent[a];
    }
    public static int union(int a, int b){
        int ar=find(a);
        int br=find(b);

        if(ar!=br){
            if(ar<br){
                parent[br]=ar;
                cnt[ar] += cnt[br];
                return cnt[ar];
            }else{
                parent[ar]=br;
                cnt[br]+=cnt[ar];
                return cnt[br];
            }
        }
        return cnt[ar];
    }
}
