import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;

class SWEA17937 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			BigInteger a = sc.nextBigInteger();
			BigInteger b = sc.nextBigInteger();
			
			if(a.equals(b)) {
				System.out.println("#"+test_case+" "+a);
			}
			else {
				System.out.println("#"+test_case+" 1");
			}
			
		}

	}
}