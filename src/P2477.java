import java.util.Scanner;

public class P2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int pos = 0;

        int N = sc.nextInt();
        int[] len = new int[7];
        int[] area = new int[6];
        int minusArea = 0;

        for (int i = 0; i < 6; i++) {
            int x = sc.nextInt();
            len[i] = sc.nextInt();
        }
        len[6] = len[0];


        for (int i = 0; i < 6; i++) {
            area[i] = len[i] * len[i + 1];
            if (area[i] > max) {
                pos = i;
                max = area[i];
            }
        }

        if (pos <= 2) {
            minusArea = area[pos + 3];
        } else if (pos >= 3) {
            minusArea = area[pos - 3];
        }


        System.out.println((max - minusArea) * N);

    }
}
