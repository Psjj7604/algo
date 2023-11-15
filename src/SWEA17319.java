
import java.util.Scanner;
import java.io.FileInputStream;


class SWEA17319
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String s = sc.next();
			String a = s.substring(0,N/2);
			String b = s.substring(N/2);
			
			if(N%2==0 && a.equals(b)) {
				System.out.println("#"+test_case+" Yes");
			}
			else {
				System.out.println("#"+test_case+" No");
			}

		}
	}
}