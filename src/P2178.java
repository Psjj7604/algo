import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1}; // 상하좌우를 결정하는 좌표.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cnt = new int[N][M];
        visited = new boolean[N][M];
        visited[0][0] = true;

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(cnt[N-1][M-1]);

    }

    public static void BFS(int a, int b){
        Queue<Pair> pairQueue = new LinkedList<>();
        pairQueue.offer(new Pair(a, b));
        cnt[a][b]=1;
        while(!pairQueue.isEmpty()){
            Pair p = pairQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if(newX <0 || newY <0 || newX >= N || newY >= M){
                    continue; //범위를 벗어나면 넘어감.
                }

                if(visited[newX][newY]==true || arr[newX][newY] == 0){
                    continue;
                }

                pairQueue.offer(new Pair(newX, newY));
                visited[newX][newY] = true;
                cnt[newX][newY] = cnt[p.x][p.y]+1;
            }


        }

    }
}
