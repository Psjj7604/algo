import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1038 {
    static List<Long> longList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            DFS(i);
        }

        Collections.sort(longList);

        System.out.println(longList.get(N));

    }

    private static void DFS(long value){
        longList.add(value);
        long remainder = value % 10;
        if(remainder ==0){
            return;
        }

        for(long i = remainder-1; i>=0; i--){
            long newValue = 10 * value + i;
            DFS(newValue);
        }

    }
}
