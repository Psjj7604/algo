import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int e, w;
    public Edge(int e, int w){
        this.e = e;
        this.w = w;
    }


    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

public class P1753 {
    static ArrayList<Edge> arrayList[];
    static int min[];
    static int V;
    static int E;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        arrayList = new ArrayList[V + 1];
        min = new int[V+1];


        Arrays.fill(min, Integer.MAX_VALUE);
        min[start] = 0;

        for (int i = 1; i < arrayList.length; i++) {
            arrayList[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList[x].add(new Edge(y, w));
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if(min[i]==Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(min[i]);
        }
    }

    static void dijkstra(int num) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(num, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            for(Edge next : arrayList[current.e]) {
                if(min[next.e] > current.w + next.w) {
                    min[next.e] = current.w + next.w;
                    priorityQueue.add(new Edge(next.e, min[next.e]));
                }
            }

        }
    }
}
