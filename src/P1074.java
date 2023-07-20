import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    static int sum=0;
    static int a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())+1;
        int c = Integer.parseInt(st.nextToken())+1;

        cal(N,r,c);

        System.out.println(sum);

    }

    public static void cal(int N, int r, int c){
        if(N<1)
            return;

        a = (int)Math.pow(2,N-1);
        if(a < r && a < c){
            if(a>1){
                sum+=3*(int)Math.pow(a,2);
                cal(N-1, r-a, c-a );
            }
            else sum+=3;

        } else if (a < r && a >= c) {
            if(a>1){
                sum+=2*(int)Math.pow(a,2);
                cal(N-1, r-a, c);
            }
            else sum+=2;
        } else if (a >= r && a < c) {
            if(a>1){
                sum+=(int)Math.pow(a,2);
                cal(N-1, r, c-a);
            }
            else sum+=1;
        } else {
            if(a>1){
                cal(N-1, r, c);
            }
            else sum+=0;
        }
    }
}
