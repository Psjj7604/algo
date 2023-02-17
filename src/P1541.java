import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정

        String[] sub = br.readLine().split("-");


        for(int i=0;i<sub.length;i++){
            int cal = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다. "+" 기호는 이스케이프 처리필요
            String[] add = sub[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다. 
            for(int j = 0; j < add.length; j++) {
                cal += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE){
                sum = cal;
            }else
                sum-=cal;

        }
        System.out.println(sum);





    }
}
