import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.io.FileInputStream;

class SWEA5684 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N + 1][N + 1];
			int[] same = new int[N + 1];

			Arrays.fill(same, 10001);

			for (int i = 1; i <= N; i++) {
				Arrays.fill(arr[i], 10001);
				arr[i][i] = 0;
			}

			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int c = sc.nextInt();
				arr[s][e] = c;

				if (s == e) {
					same[s] = Math.min(same[s], c);
				} else {
					arr[s][e] = c;
				}
			}
			
			int anwser = minCycle(arr, same);
			System.out.println("#" + test_case + " " + anwser);

		}
	}

	static int minCycle(int[][] arr, int[] same) {
		int min = 10001;

		for (int k = 1; k < arr.length; k++) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (i != j && arr[i][j] != 10001) {
					min = Math.min(min, arr[i][j] + arr[j][i]);
				}
			}
		}
		
		for (int i = 1; i < same.length; i++) {
            if (same[i] != 10001) {
                min = Math.min(min, same[i]);
            }
        }

		return min == 10001 ? -1 : min;
	}

}