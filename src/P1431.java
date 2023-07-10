import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    if(cal(o1)-cal(o2)==0){
                        return o1.compareTo(o2);
                    }
                    else
                        return cal(o1)-cal(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    static int cal(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sum += s.charAt(i)-'0';
            }
        }
        return sum;
    }
}
