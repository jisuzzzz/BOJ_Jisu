import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;

public class 백준1753 {
    static class Node{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    static List<ArrayList<Node>> graph;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        visit = new boolean[v+1];
        dist = new int[v+1];

        for(int i=0; i<=v; i++){
            graph.add(new ArrayList<>());
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n_u = Integer.parseInt(st.nextToken());
            int n_v = Integer.parseInt(st.nextToken());
            int n_w = Integer.parseInt(st.nextToken());

            graph.get(n_u).add(new Node(n_v, n_w));
        }
        dijkstra(k);
        for(int i=1; i<=v; i++){
            if(dist[i]==Integer.MAX_VALUE)System.out.println("INF");
            else System.out.println(dist[i]);
            // System.out.println(dist[i]==11 ? "INF" : dist[i]);
        }
    }
    static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        pq.add(new Node(s,0));
        dist[s]=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visit[now.v]){
                visit[now.v]=true;
            }
            for(Node next : graph.get(now.v)){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v]=now.cost+next.cost;
                    pq.add(new Node(next.v,dist[next.v]));
                }
            }
        }
    }
}
