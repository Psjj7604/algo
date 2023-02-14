import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10001];

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
/**
 *  Counting sort를 이용하여 n+k의 시간복잡도를 보장.
 */
        for(int i = 0; i < N; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        for(int i=0;i<10001;i++){
            while(cnt[i]>0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);


    }
}
