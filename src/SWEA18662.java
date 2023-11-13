import java.util.Scanner;
import java.io.FileInputStream;

class SWEA18662 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			float x = Math.abs((float) (a + c) / 2 - b);

			System.out.printf("#" + test_case + " " + "%.1f", x);
			System.out.println();

		}

	}
}