import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size()!=1){
            int tmp1 = queue.poll();
            int tmp2 = queue.poll();
            queue.add(tmp2);
        }
        int num = queue.poll();
        System.out.println(num);
    }
}
