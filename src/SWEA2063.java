import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
class SWEA2063
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] arr = new int[T];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr[test_case-1]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[(T+1)/2-1]);

    }
}
