import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    if(o1>o2){
                        return 1; //양수면 자리 변경
                    }else
                        return -1; //음수면 자리 유지 (최소 힙은 오름차순 형태)
                }

                else
                    return Math.abs(o1) - Math.abs(o2);
            }
        });

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());

            if(input==0){
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
