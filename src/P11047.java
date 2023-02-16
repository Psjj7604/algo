import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for(int i=N-1;i>=0;i--){
            while(k>=arr[i]){
                k = k - arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
