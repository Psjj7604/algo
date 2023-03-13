import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int longest = Math.max(Math.max(a,b),c);
            if(a==0 && b==0 && c==0) break;
            else if ( (a+b+c) <= 2*longest) {
                System.out.println("Invalid");
            } else if (a==b && b==c && a==c) {
                System.out.println("Equilateral");
            } else if ( (a==b && a!=c) || (b==c && a!=b) || (a==c && a!=b) ) {
                System.out.println("Isosceles");
            } else
                System.out.println("Scalene");

        }
    }
}
