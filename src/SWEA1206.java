import java.util.Scanner;

class SWEA1206 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(Math.max(Math.max(arr[i-2],arr[i-1]),arr[i+1]),arr[i+2]);
                if(arr[i]>max){
                    sum+=arr[i]-max;
                }
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}