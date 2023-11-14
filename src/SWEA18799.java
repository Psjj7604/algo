import java.util.Scanner;

class SWEA18799 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			boolean dec = false;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];

			}
			String a = String.format("%.20f", (double) sum / N);

			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == '.') {
					dec = true;
				}

				if (dec != false && a.charAt(i) == '0') {
					if (a.charAt(i - 1) == '.') {
						a = a.substring(0, i - 1);
					} else {
						a = a.substring(0, i);
					}

				}

			}

			System.out.println("#" + test_case + " " + a);

		}
	}
}