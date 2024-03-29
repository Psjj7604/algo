import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {
    static boolean[][] visited;
    static char[][] arr;
    static class Pair{
        int x,y;

        Pair(int a,int b){
            this.x= a;
            this.y= b;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        int cnt1=0;
        int cnt2=0;

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs2(i,j);
                    cnt1++;
                }
            }
        }
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {;
            for (int j = 0; j < N; j++) {
                if(arr[i][j]=='R')
                    arr[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs2(i,j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1+" "+cnt2);

    }

    /*static void bfs1(int a, int b){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(a, b));
        visited[a][b] = true;

        while(!queue.isEmpty()){
            Pair P = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = P.x + dx[i];
                int newY = P.y + dy[i];

                if(newX < 0 || newY < 0 || newX>= arr.length || newY>=arr.length){
                    continue;
                }

                if(visited[newX][newY] || arr[newX][newY]=='B'){
                    continue;
                }

                queue.offer(new Pair(newX, newY));
                visited[newX][newY] = true;

            }
        }
    }*/

    static void bfs2(int a, int b){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(a, b));

        visited[a][b] = true;
        while(!queue.isEmpty()){
            Pair P = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = P.x + dx[i];
                int newY = P.y + dy[i];

                if(newX < 0 || newY < 0 || newX>= arr.length || newY>=arr.length){
                    continue;
                }

                if(visited[newX][newY] || arr[newX][newY]!=arr[a][b]){
                    continue;
                }

                queue.offer(new Pair(newX, newY));
                visited[newX][newY] = true;

            }
        }
    }
}
