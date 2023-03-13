import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723 {
//    static boolean[] S = new boolean[20 + 1]; boolean으로 했을시 시간 초과 발생, 비트마스크를 활용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int bitset = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String op = st.nextToken();

            switch (op) {
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitset &= ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    int tmp = bitset & (1 << (num - 1));
                    sb.append( (tmp==0 ? 0 : 1) + "\n" );
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (num-1));
                    break;
                case "all":
                    bitset |= (~0);
                    break;
                case "empty":
                    bitset &=0;
                    break;

            }

        }
        System.out.println(sb);
    }
}

   /* public static void add(int i, boolean[] S){
        if(S[i] == true)
            return;
        else{
            S[i]=true;
        }
    }

    public static void remove(int i, boolean[] S){
        if(S[i] == false)
            return;
        else{
            S[i]=false;
        }
    }

    public static void check(int i, boolean[] S){
        if(S[i] == true)
            System.out.println("1");
        else{
            System.out.println("0");
        }
    }

    public static void toggle(int i, boolean[] S){
        if(S[i] == true)
            S[i] = false;
        else{
            S[i] = true;
        }
    }

    public static void all(boolean[] S){
        for (int j = 1; j < S.length; j++) {
            S[j] = true;
        }
    }

    public static void empty(boolean[] S){
        for (int j = 1; j < S.length; j++) {
            S[j] = false;
        }
    }

*/