import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    public static int min = 999;

    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j=0; j < M;j++){
                if(str.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }

        int row = N - 7;
        int column = M - 7;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                find(i, j);
            }
        }

        System.out.println(min);



    }

    public static void find(int N, int M){
        boolean compareArr = arr[N][M];
        int cnt = 0;
        for(int i=N; i<N+8;i++){

            for(int j=M;j<M+8;j++){
                if(arr[i][j] != compareArr){
                    cnt++;
                }
                compareArr = !compareArr;  //정상의 경우 흑백이 뒤바뀌므로 비교 이후 true -> false(반대 경우도)
            }
            compareArr = !compareArr;
        }

        cnt = Math.min(cnt, 64-cnt); //흑색(또는 백)을 기준으로 했을 때 반대의 경우도 고려해야함. 전체 64개에서 cnt 마이너스
        min = Math.min(cnt, min); //가장 최소값 찾기
    }
}
