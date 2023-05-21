import java.io.*;

public class 백준1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        System.out.println(df(n,0));
        
    }
    public static int df(int n, int cnt){
        if(n<2){
            return cnt;
        }
        return Math.min(df(n / 2, cnt + 1 + (n % 2)), df(n / 3, cnt + 1 + (n % 3)));
    }

}
