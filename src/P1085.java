import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = Integer.MAX_VALUE;

        int[] arr = {h-y,w-x,x,y};

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println(min);
    }
}
