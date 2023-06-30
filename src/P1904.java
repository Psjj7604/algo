import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904 {
    public static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(sum(N));
    }

    public static int sum(int N) {
        if(dp[N] == -1){
            dp[N] = ( sum(N-1) + sum(N-2) ) % 15746;
        }
        return dp[N];
    }
}
