import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9019 {
    static String[] answer;
    static boolean[] visited;
    static int D, S, L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            answer = new String[10000];
            Arrays.fill(answer,"");  // java 11 이후로 지원되는 for문을 쓰지 않고 배열 초기화하는 방법
            visited = new boolean[10000];

            BFS(A, B);

            System.out.println(answer[B]);
        }
    }

    static void BFS(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        visited[a] = true;
        q.offer(a);

        while (!q.isEmpty() && !visited[b]) {
            int num = q.poll();
            D = (num < 5000) ? 2 * num : (2 * num) % 10000;
            S = (num == 0) ? 9999 : num - 1;
            L = (num % 1000) * 10 + num / 1000;
            R = (num % 10) * 1000 + num / 10;

            if(!visited[D]){
                q.offer(D);
                visited[D]=true;
                answer[D]=answer[num] + "D";
            }

            if(!visited[S]){
                q.offer(S);
                visited[S]=true;
                answer[S]=answer[num] + "S";
            }

            if(!visited[L]){
                q.offer(L);
                visited[L]=true;
                answer[L]=answer[num] + "L";
            }

            if(!visited[R]){
                q.offer(R);
                visited[R]=true;
                answer[R]=answer[num] + "R";
            }



        }
    }


}
