
import java.util.Scanner;
import java.io.FileInputStream;


class SWEA2001 {
    static int[][] arr;
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = Integer.MIN_VALUE;

            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    if(cal(i, j, M) > max){
                        max = cal(i, j, M);
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }

    }

    public static int cal(int x, int y, int M){
        int sum = 0;
        for (int i = x; i < x+M; i++) {
            for (int j = y; j < y+M; j++) {
                sum+=arr[i][j];
            }
        }
        return sum;
    }
}