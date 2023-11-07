import java.util.Scanner;
import java.io.FileInputStream;


class SWEA1954 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = 1;
            arr = new int[N][N];
            visited = new boolean[N][N];
            dfs(0, 0, 0);

            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void dfs(int x, int y, int dir) {
        visited[x][y] = true;
        arr[x][y] = M++;

        int newX = x + dx[dir];
        int newY = y + dy[dir];

        if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
            {
                if (!visited[newX][newY]) {
                    dfs(newX, newY, dir);
                    return;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            newX = x + dx[i];
            newY = y + dy[i];

            if (newX < 0 || newX >= N || newY < 0 || newY >= N)
                continue;

            if (!visited[newX][newY]) {
                dfs(newX, newY, i);
            }
        }


    }
}