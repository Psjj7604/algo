import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st = br.readLine();
        int[] cnt = new int[10];

        for (int i = 0; i < st.length(); i++) {
            cnt[st.charAt(i) -'0']++;  // -'0'...
        }


        for (int i = 9; i >= 0; i--) {
            while(cnt[i]>0){
                System.out.print(i);
                cnt[i]--;
            }
        }
    }
}
