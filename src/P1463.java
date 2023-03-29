import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    private static int N;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        System.out.println(cal(N,0));
    }

    private static int cal(int N, int cnt){
        if(N<2){
            return cnt;
        }else {
            return Math.min(cal(N / 2, cnt + 1 + (N % 2)), cal(N / 3, cnt + 1 + (N % 3)));
        }

    }
/* DP 방식으로 풀면 다음과 같음.
    static int recur(int N) {

        if (dp[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }*/
}
