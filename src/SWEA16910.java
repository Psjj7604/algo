
import java.util.Scanner;

class SWEA16910
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int A = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(Math.pow(i,2)+Math.pow(j,2)<=N*N){
                        A++;
                    }
                }
            }
            int sum = 4*N+4*A+1;
            System.out.println("#"+test_case+" "+sum);
        }
    }
}