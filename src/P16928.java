import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    static boolean[] visited = new boolean[101];
    static int[] cnt = new int[101];
    static int[] jmp = new int[101];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            jmp[x] = y;
        }

        bfs();


    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        cnt[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if(pos==100){
                System.out.println(cnt[pos]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int newX = pos + i;

                if(newX>100)
                    continue;
                if(visited[newX])
                    continue;
                visited[newX] = true;

                if(jmp[newX]!=0){
                    if(!visited[jmp[newX]]){
                        queue.offer(jmp[newX]);
                        visited[jmp[newX]] = true;
                        cnt[jmp[newX]] = cnt[pos] +1;
                    }


                }
                else{
                    queue.offer(newX);
                    cnt[newX] = cnt[pos]+1;
                }
            }


        }


    }
}
