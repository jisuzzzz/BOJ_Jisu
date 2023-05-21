import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;

public class 백준1916{
    static class Node{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    static boolean[] visit;
    static List<ArrayList<Node>> graph;
    static int[] dist;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visit = new boolean[n+1];
        dist = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int s_city = Integer.parseInt(st.nextToken());
            int e_city = Integer.parseInt(st.nextToken());
            int b_cost = Integer.parseInt(st.nextToken());

            graph.get(s_city).add(new Node(e_city, b_cost));
        }
        st = new StringTokenizer(br.readLine());
        int ans_s_city = Integer.parseInt(st.nextToken());
        int ans_e_city = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(ans_s_city,ans_e_city));
    }
    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost-o2.cost);
        pq.offer(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
                for (Node next : graph.get(now.v)) {
                    if (dist[next.v] > now.cost + next.cost) {
                        dist[next.v] = now.cost + next.cost;
                        pq.offer(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        return dist[end];
    }
}