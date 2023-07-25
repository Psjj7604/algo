import java.util.Scanner;
import java.io.FileInputStream;

class SWEA1859{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int max = -1;
            long total = 0;

            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }

            for (int i = N - 1; i >= 0; i--) {
                if(arr[i] > max){
                    max = arr[i];
                }
                else{
                    total = total + max - arr[i];
                }
            }
            System.out.println("#"+test_case+" "+total);

        }
    }
}