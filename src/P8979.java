import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][3];
        int rank = 1;


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int countryNum = Integer.parseInt(st.nextToken());
            arr[countryNum][0] = Integer.parseInt(st.nextToken());
            arr[countryNum][1] = Integer.parseInt(st.nextToken());
            arr[countryNum][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            if(arr[i][0] > arr[M][0]) { //비교 대상이 금메달이 더많으면 랭킹 +1
                rank++;
            }
            else if(arr[i][0] == arr[M][0] && arr[i][1] > arr[M][1]) { // 금 갯수는 같고 은이 더 작을 때
                rank++;
            }
            else if(arr[i][0] == arr[M][0] && arr[i][1] == arr[M][1] && arr[i][2] > arr[M][2]) {
                rank++;
            }
        }


        System.out.println(rank);

    }
}
