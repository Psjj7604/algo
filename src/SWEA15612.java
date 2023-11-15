
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA15612 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0;
			boolean check=false;
			boolean[][] visited = new boolean[8][2];
			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == 'O') {
						if (visited[i][0] != true && visited[j][1] != true) {
							visited[i][0] = true;
							visited[j][1] = true;
							cnt++;
						} else {
							check=true;
						}
					}
				}
			}

			if (cnt != 8 || check==true)
				System.out.println("#" + test_case + " no");
			else
				System.out.println("#" + test_case + " yes");

		}
	}
}
