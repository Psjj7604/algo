import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        int sum = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1; //첫 칸에는 넣지 않거나 왼쪽, 오른쪽에 배치할 수 있음

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][0]%=9901;
            dp[i][1]%=9901;
            dp[i][2]%=9901;
        }
        for (int i = 0; i < 3; i++) {
            sum+=dp[N][i];
        }

        System.out.println(sum%9901);

    }
}
