import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String st = br.readLine();
            int left = 0;
            int right = 0;

            for (int j = 0; j < st.length(); j++) {
                if (j == 0) {
                    if (st.charAt(j) == '(') {
                        left++;
                        continue;
                    } else{
                        System.out.println("NO");
                        break;
                    }
                }
                else if (j == st.length() - 1) {
                    if (st.charAt(j) == ')' && left == right+1) {
                        System.out.println("YES");
                    } else
                        System.out.println("NO");
                }
                else {
                    if (left < right) {
                        System.out.println("NO");
                        break;
                    } else {
                        if (st.charAt(j) == '(') {
                            left++;
                        } else if (st.charAt(j) == ')') {
                            right++;
                        } else {
                            System.out.println("NO");
                            break;
                        }
                    }

                }
            }


        }


    }
}
