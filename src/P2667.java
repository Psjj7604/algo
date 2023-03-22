import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static int cnt;
    static int N;
    static List getApart;
    static boolean[][] visited;
    static int[][] arr;
    static int num;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; // 상하좌우를 결정하는 좌표.
    static List apart;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        getApart = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != true && arr[i][j] != 0) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(getApart);
        for (int i = 0; i < getApart.size(); i++) {
            System.out.println(getApart.get(i));
        }
    }

    static void BFS(int a, int b) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(a, b));
        visited[a][b]=true;
        arr[a][b]=++cnt;
        num=1;


        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = pair.x + dx[i];
                int newY = pair.y + dy[i];
                if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
                    continue; //범위를 벗어나면 넘어감.
                }
                if (visited[newX][newY] == true || arr[newX][newY] == 0) {
                    continue;
                }
                queue.offer(new Pair(newX, newY));
                arr[newX][newY] = cnt;
                visited[newX][newY] = true;
                num++;
            }
        }
        getApart.add(num);


    }
}

