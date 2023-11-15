
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA16800 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			long min = Long.MAX_VALUE;
			long N = sc.nextLong();
			long a, b;

			for (long i = 1; i <= Math.sqrt(N); i++) {
				if (N % i == 0) {
					a = i;
					b = N / i;

					if (min > (a + b - 2)) {
						min = (a + b - 2);
					}
				}
			}

			System.out.println("#" + test_case + " " + min);

		}
	}
}