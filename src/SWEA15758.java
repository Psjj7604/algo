import java.util.Scanner;

class SWEA15758 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = "";
            String s4 = "";

            int a = s1.length();
            int b = s2.length();

            for (int i = 0; i < b; i++) {
                s3 = s3.concat(s1);
            }

            for (int i = 0; i < a; i++) {
                s4 = s4.concat(s2);
            }

            if(s3.equals(s4)){
                System.out.println("#"+test_case+" yes");
            }
            else
                System.out.println("#"+test_case+" no");


        }
    }

}