import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class SWEA1244 {
    static int max;
    static int N;
    static String[] st;
    static boolean[][] visited;
    static String answer;

    public static void main(String args[]) throws Exception {
        StringTokenizer stringTokenizer;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            st = stringTokenizer.nextToken().split("");
            N = Integer.parseInt(stringTokenizer.nextToken());
            max = Integer.MIN_VALUE;
            visited = new boolean[2][1000000];

            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void dfs(int depth, int pos) {
        if (depth == N) {
            answer = "";
            for (String s : st) {
                answer += s;
            }
            max = Math.max(max, Integer.parseInt(answer));
            return;
        }

        for (int i = pos; i < st.length - 1; i++) {
            for (int j = i + 1; j < st.length; j++) {
                String tmp = st[i];
                st[i] = st[j];
                st[j] = tmp;
                answer = "";
                for (String s:st) {
                    answer += s;
                }
                /**
                 *
                 * 남은 탐색 횟수가 1일 때, 중복된 값이 존재할 시 교환이 이뤄져선 안되는 경우 존재
                 */
                if(!visited[depth%2][Integer.parseInt(answer)]){
                    visited[depth%2][Integer.parseInt(answer)]=true;
                    dfs(depth + 1, pos);
                }
                tmp = st[i];
                st[i] = st[j];
                st[j] = tmp;
            }
        }
    }
}