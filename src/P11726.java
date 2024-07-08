import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11726 {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cal(n);
        System.out.println(arr[n]);

    }

    public static void cal(int n){
        arr[0]=1;
        arr[1]=1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

    }
}
