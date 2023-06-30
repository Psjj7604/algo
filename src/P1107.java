import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] error = new boolean[10];

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                error[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int digit = str.length();

            boolean check = false;
            for (int j = 0; j < digit; j++) {
                if (error[str.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                int min = Math.abs(N - i) + digit;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);

    }
}
