import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
/**
 *  Comparator활용하여 compare함수 override,
 *  compareTo 활용하기  문자열은 사전식으로, 기준값-비교값 계산으로 양수,0,음수로 구분(기준값이 큰 경우 양수)
 */
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else
                    return s1.length() - s2.length();
            }
        });

        sb.append(arr[0]).append('\n');

        for (int i = 1; i < N; i++) {
            if(!arr[i-1].equals(arr[i]))
                sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);



    }
}
