import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /**
         * 우선 순위 큐(최소 힙)를 reverseOrder로 생성로 생성하여 poll 할 때 최대 값이 출력
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                if(!priorityQueue.isEmpty()){
                    System.out.println(priorityQueue.poll());
                }
                else {
                    System.out.println("0");
                }
                continue;
            }
            priorityQueue.add(input);
        }


    }
}
