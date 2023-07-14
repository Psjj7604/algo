import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr2 = new int[N];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }

        int rank = 0;

        Arrays.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            if (!hashMap.containsKey(arr2[i])) {
                hashMap.put(arr2[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(hashMap.get(arr[i])).append(" ");
        }

        System.out.println(sb);



    }
}
