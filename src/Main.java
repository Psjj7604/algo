import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] ranks = new int[n+1]; // initialize ranks array
            for (int i = 1; i <= n; i++) {
                ranks[sc.nextInt()] = i;
            }

            int m = sc.nextInt();
            int[] pair1 = new int[m];
            int[] pair2 = new int[m];
            for (int i = 0; i < m; i++) {
                pair1[i] = sc.nextInt();
                pair2[i] = sc.nextInt();
            }

            int[] ans = new int[n+1]; // initialize ans array
            Arrays.fill(ans, -1); // fill ans array with -1
            for (int i = 1; i <= n; i++) {
                if (ans[i] != -1) {
                    continue;
                }
                ans[i] = i;
                dfs(i, ranks, pair1, pair2, ans);
            }

            boolean impossible = false;
            for (int i = 1; i <= n; i++) {
                if (ans[i] == -1) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 1; i <= n; i++) {
                    System.out.print((ans[i] == -1) ? "?" : ans[i]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        sc.close();
    }

    static void dfs(int u, int[] ranks, int[] pair1, int[] pair2, int[] ans) {
        for (int i = 0; i < pair1.length; i++) {
            int x = ranks[pair1[i]];
            int y = ranks[pair2[i]];
            if (x < u && u < y) {
                if (ans[x] == -1) {
                    ans[x] = y;
                    dfs(x, ranks, pair1, pair2, ans);
                } else if (ans[x] != y) {
                    ans[x] = -1;
                }
            } else if (y < u && u < x) {
                if (ans[y] == -1) {
                    ans[y] = x;
                    dfs(y, ranks, pair1, pair2, ans);
                } else if (ans[y] != x) {
                    ans[y] = -1;
                }
            }
        }
    }
}
