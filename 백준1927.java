import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준1927 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n= Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num>0)pq.add(num);
            else {
                if (!pq.isEmpty()) System.out.println(pq.poll());
                else System.out.println(0);
            }
        }
        br.close();
    }
}
