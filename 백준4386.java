import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class 백준4386 {
    static class Star{
        double x; double y;
        public Star(double x, double y){
            this.x=x;
            this.y=y;
        }
    }
    static class Star_Dist{
        int p; int q;
        double cost;
        public Star_Dist(int p,int q,double cost){
            this.p=p;
            this.q=q;
            this.cost=cost;
        }
    }
    static int n;
    static int[] parent;
    static ArrayList<Star_Dist> s_t_list;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        HashMap<Integer,Star> star_loc = new HashMap<>();
        s_t_list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            parent[i]=i;
        }
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            double loc1 = Double.parseDouble(str[0]);
            double loc2 = Double.parseDouble(str[1]);
            star_loc.put(i+1,new Star(loc1,loc2));
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                double sdist = Math.sqrt(Math.pow(star_loc.get(i).x-star_loc.get(j).x,2)+Math.pow(star_loc.get(i).y-star_loc.get(j).y,2));
                s_t_list.add(new Star_Dist(i, j, sdist));
            }
        }
        Collections.sort(s_t_list, (o1, o2) -> Double.compare(o1.cost, o2.cost));

        double ans = 0;
        for(int i=0; i<s_t_list.size(); i++){
            Star_Dist now = s_t_list.get(i);
            if(find(now.p)!=find(now.q)){
                union(now.p,now.q);
                ans+=now.cost;
            }
        }
        System.out.println(ans);
    }
    static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b); 
        if(a!=b){
            parent[b]=a;
        }
    }
}
/*
 * (1,1) (2,2) (2,4) 음...연결을 할 때마다 두 별 사이 좌표값 만큼 비용이 생긴다(모든 별이 직/간접적으로 연결)...별자리를 만드는 최소 비용 
 * (1,1) 이랑 (2,2) 연결하면 거리는 루트2 (1,1) 이랑 (2,4)랑 연결하면 거리는 루트10 최종 루트2+루트10?
 * (2,2) 이랑 (2,4)를 연결하면 거리는 2 
 * 1->2->3 >>> 루트2+2
 * 1->2 1->3 >>> 루트2+루트10
 * 음음음음음음으..............
 * 그럼 다 구해봐야 하나????????? 음.....일단 좌표값을 받으면 거리를 다 계산을 해놓고 그거를 연결 시켜줘야 함...union-find로 연결성 검사
 */