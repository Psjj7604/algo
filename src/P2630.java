import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static int arr[][];
    static int N;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(N, arr, 0, 0);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void dp(int a, int[][] arr, int x, int y) {
        if (colorCheck(x, y, a)) {
            if (arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }
        dp(a / 2, arr, x, y);
        dp(a / 2, arr, x, y + a / 2);
        dp(a / 2, arr, x + a / 2, y);
        dp(a / 2, arr, x + a / 2, y + a / 2);
    }


    public static boolean colorCheck(int x, int y, int a) {
        int color = arr[x][y];

        for (int i = x; i < x + a; i++) {
            for (int j = y; j < y + a; j++) {
                if (arr[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}
