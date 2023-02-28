import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
/**
 * 최대 힙, 최소 힙으로 두개의 우선 순위 큐를 사용하여, 1차원 배열과 같은 형태를 만듦.
 * 최대 큐의 루트 값이 항상 중앙값을 나타낼 수 있게 함. 기존에 자주 사용한 sort의 시간 복잡도
 * Arrays.sort()	DualPivotQuicksort	평균 : O(nlog(n)) / 최악 : O(n^2)
 * Collections.sort()	TimeSort (삽입정렬과 합병정렬을 결합한 정렬)	평균, 최악 : O(nlog(n))
 * 우선 순위 큐의 경우 logn의 시간 복잡도를 가짐.
 */
        for(int i=0; i<N; i++){
            int M = Integer.parseInt(br.readLine());

            if(maxPQ.size() == minPQ.size()) {
                maxPQ.add(M);

                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }

            }
            else
            {
                minPQ.add(M);
                if(maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);

        /* 시간 복잡도가 N * nlogn 으로 시간초과 발생.
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int cnt = 0;

        for(int i=0;i<N;i++){
            integerArrayList.add(Integer.parseInt(br.readLine()));
            cnt++;
            Collections.sort(integerArrayList);
            if(cnt%2==0){
                System.out.println(integerArrayList.get(cnt/2-1));
            }
            else
                System.out.println(integerArrayList.get(cnt/2));
        }*/
    }
}
