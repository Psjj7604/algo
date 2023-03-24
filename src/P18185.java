import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (arr[i] > 0) {
                if (i + 2 < N && arr[i + 1] > 0 && arr[i + 2] > 0 && arr[i+1] <= arr[i+2]) {
                    arr[i]--;
                    arr[i + 1]--;
                    arr[i + 2]--;
                    sum += 7;
                    continue;
                }

                if(i+1 <N && arr[i+1] >0){
                    arr[i]--;
                    arr[i+1]--;
                    sum+=5;
                    continue;
                }

                arr[i]--;
                sum+=3;

            }
        }

        System.out.println(sum);

    }
}
