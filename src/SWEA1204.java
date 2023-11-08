import java.util.Scanner;


class SWEA1204
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[101];
            int max = -1;
            int num = 0;

            for (int i = 0; i < 1000; i++) {
                arr[sc.nextInt()]++;
            }

            for (int i = 0; i < 101; i++) {
                if(arr[i]>=max){
                    max = arr[i];
                    num = i;
                }
            }
            System.out.println("#" +N+" "+num);
        }

    }
}