import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[8001];
        int sum = 0, median = 10000,mode = 10000;
        int max=-99999;
        int min=99999;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            cnt[value+4000]++;
            sum += value;
            if(value>max)
                max = value;
            if(value<min)
                min = value;
        }

        int count = 0;	// 중앙값 빈도 누적 수
        int mode_max = 0; 	// 최빈값의 최댓값

        // 이전의 동일한 최빈값이 1번만 등장했을경우 true, 아닐경우 false
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {

            if(cnt[i] > 0) {

                /*
                 * <중앙값 찾기>
                 * 누적횟수가 전체 전체 길이의 절반에 못 미친다면
                 */
                if(count < (N + 1) / 2) {
                    count += cnt[i];	// i값의 빈도수를 count 에 누적
                    median = i - 4000;
                }

                /*
                 * <최빈값 찾기>
                 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                 */
                if(mode_max < cnt[i]) {
                    mode_max = cnt[i];
                    mode = i - 4000;
                    flag = true;	// 첫 등장이므로 true 로 변경
                }
                // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                else if(mode_max == cnt[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println(Math.round((double)sum/N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max-min);
    }
}
