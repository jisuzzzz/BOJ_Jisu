import java.util.Scanner;

public class 백준1495 {
    static int N;
    static int S;
    static int M;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        
        sc.close();
    }
}
