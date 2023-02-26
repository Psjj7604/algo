import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class P24444 {
    private static int cnt =0;
    private static int[] result = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] adj = new LinkedList[N + 1];

        for(int i=1;i<=N;i++){
            adj[i] = new LinkedList<>();
        }

        /** 노드간 연결(양방향)
         *
         */
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        /**
         *  오름차순 정렬
         */
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        boolean[] visited = new boolean[N + 1];

        BFS(R,adj,visited);

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int R, LinkedList<Integer>[] adj, boolean[] visited){
        Queue<Integer> integerQueue = new LinkedList<Integer>();
        visited[R] = true;
        integerQueue.add(R);

        while (integerQueue.size() != 0) {
            R = integerQueue.poll();
            result[R] = ++cnt;

            Iterator<Integer> iter = adj[R].listIterator();
            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]){
                    visited[w] = true;
                    integerQueue.add(w);
                }
            }
        }

    }
}
