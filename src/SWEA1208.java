
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

class SWEA1208
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T=10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dump = sc.nextInt();
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int i = 0; i < dump; i++) {

                if(arr[99]-arr[0]>1){
                    arr[99]--;
                    arr[0]++;
                    Arrays.sort(arr);
                }
                else{
                    System.out.println("#"+test_case+" "+(arr[99]-arr[0]));
                    return;
                }
            }
            System.out.println("#"+test_case+" "+(arr[99]-arr[0]));

        }
    }
}