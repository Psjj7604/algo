import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11724 {
    private static int N, M;
    private static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] adj = new LinkedList[N + 1]; //인접 리스트로 표현

        for(int i=1; i<=N; i++){
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
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                DFS(i,adj,visited);
                cnt++;
            }
        }


        System.out.println(cnt);


    }

    public static void DFS(int R, LinkedList<Integer>[] adj, boolean[] visited){
        Iterator<Integer> iter = adj[R].listIterator();
        visited[R]=true; // R은 시작 노드

        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                DFS(w, adj, visited);
            }
        }

    }
}
