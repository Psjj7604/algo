import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] rank = new int[N + 1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int countryNum = Integer.parseInt(st.nextToken());
            String sum = st.nextToken()+st.nextToken()+st.nextToken();
            int cnt = Integer.parseInt(sum);

            arr[countryNum] = cnt;
        }

        for (int i = 1; i <= N; i++) {
            rank[i] =1;
            for (int j = 1; j <= N; j++) {
                if(i==j)
                    continue;

                if(arr[i]<arr[j]){
                    rank[i]++;
                }
            }
        }

        System.out.println(rank[M]);

    }
}
