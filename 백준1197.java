import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 백준1197 {
    static class Node {
        int v1;
        int v2;
        int cost;
        public Node(int v1, int v2, int cost){
            this.v1=v1;
            this.v2=v2;
            this.cost = cost;
        }
    }
    static ArrayList<Node> graph;
    static int[] parent;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i]=i;
        }
        for(int i=0; i<E; i++){
            String[] str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            graph.add(new Node(a,b,c));
        }
        Collections.sort(graph, (o1, o2) -> o1.cost - o2.cost);
        

        int ans = 0;
        for(int i=0; i<graph.size(); i++){
            Node now = graph.get(i);
            if(find(now.v1) != find(now.v2)){
                union(now.v1, now.v2);
                ans += now.cost;
            }
        }
        System.out.println(ans);
    }
    static int find(int x){
        if(parent[x]==x)return x;
        else return parent[x]=find(parent[x]);
    }
    static void union(int x, int y){
        int xr = parent[x];
        int yr = parent[y];
        if(xr!=yr){
            parent[yr]=xr;
        }
    }
}
