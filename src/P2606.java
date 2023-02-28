import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class P2606 {
    private static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] adj = new LinkedList[N + 1];

        for(int i=1;i<=N;i++){
            adj[i] = new LinkedList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(adj[i]);
        }

        boolean visited[] = new boolean[N + 1];

        BFS(1, adj, visited);

        System.out.println(cnt-1);
    }

    private static void BFS(int R, LinkedList<Integer>[] adj, boolean[] visited){
        visited[R] = true;
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(R);

        while(integerQueue.size()!=0){
            R = integerQueue.poll();
            cnt++;
            Iterator<Integer> iter = adj[R].listIterator();  //자주 깜빡하는 부분

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
