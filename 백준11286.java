import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준11286{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            int a_abs = Math.abs(a);
            int b_abs = Math.abs(b);
            if(a_abs==b_abs) return a>b ? 1:-1;
            else return a_abs - b_abs;
            
        });

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num!=0) pq.offer(num);
            else{
                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append("0\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}