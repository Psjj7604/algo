import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2667 {
    static int cnt;
    static boolean[][] visited;
    static int[][] arr;

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

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        visited[0][0] = true;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }



    }

    static void BFS(int a, int b){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(a,b));
        cnt++;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            cnt++;
            Iterator<Integer> iter = arr[pair][pair].listIterator();  //자주 깜빡하는 부분

            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    integerQueue.add(w);
                }
            }

            }
        }
    }
}

