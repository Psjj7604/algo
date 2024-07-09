import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class Point {
        int x, y, cnt;
        boolean broken;

        public Point(int x, int y, int cnt, boolean broken) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broken = broken;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        BFS(0, 0, 1, false);


    }

    public static void BFS(int a, int b, int c, boolean d) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b, c, d));
        visited[a][b][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == arr.length - 1 && p.y == arr[0].length - 1) {
                System.out.println(p.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= arr.length || newY >= arr[0].length) {
                    continue;
                }

                if (arr[newX][newY] == 0) {
                    if (!visited[newX][newY][0] && !p.broken) {
                        queue.offer(new Point(newX, newY, p.cnt + 1, false));
                        visited[newX][newY][0] = true;
                    } else if (!visited[newX][newY][1] && p.broken) {
                        queue.offer(new Point(newX, newY, p.cnt + 1, true));
                        visited[newX][newY][1] = true;
                    }
                } else if (arr[newX][newY] == 1) {
                    if (!p.broken) {
                        queue.offer(new Point(newX, newY, p.cnt + 1, true));
                        visited[newX][newY][1] = true;
                    }
                }


            }


        }
        System.out.println(-1);

    }
}
