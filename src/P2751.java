import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list); // Timsort : n ~ nlogn의 시간 복잡도 보장, 이 경우 합병 및 삽입정렬 알고리즘을 사용
//        Arrays.sort(arr);  최악의 경우 n제곱 시간 복잡도로 시간 초과발생

        for (int value : list) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }
}
