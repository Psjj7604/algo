import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static boolean[][] visited;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int M;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false; // 모양에 따라 재방문 가능
            }
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int num, int cnt) {

        if (cnt == 4) {
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                continue;
            }

            if (!visited[newX][newY]) {

                if (cnt == 2) {  // ㅗ 모양 탐색을 고려하여 2번째 위치에서 재 탐색.
                    visited[newX][newY] = true;
                    dfs(x, y, num + arr[newX][newY], cnt + 1);
                    visited[newX][newY] = false;
                }

                visited[newX][newY] = true;
                dfs(newX, newY, num + arr[newX][newY], cnt + 1);
                visited[newX][newY] = false;
            } else {
                continue;
            }
        }
    }
}
