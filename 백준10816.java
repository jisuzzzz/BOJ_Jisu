import java.util.HashMap;
import java.util.Scanner;

public class 백준10816 {
	private static StringBuilder sb;
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            int key = sc.nextInt();
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        int m = sc.nextInt();
        sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int key = sc.nextInt();
            sb.append(hm.getOrDefault(key, 0)).append(' ');
        }
        System.out.println(sb);
        sc.close();
	}
}
