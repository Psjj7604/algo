import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N + 1][2];
        StringTokenizer st;
        long x = 0, y = 0;
        long result;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        for (int i = 0; i < N; i++) {
            x += arr[i][0] * arr[i + 1][1];
            y += arr[i][1] * arr[i + 1][0];
        }

        result = Math.abs(x-y);
        System.out.printf("%.1f", (double)result/2);

    }
}
