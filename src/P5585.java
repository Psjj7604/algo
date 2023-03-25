import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int change = 1000-N;
        int cnt=0;
        int tmp;

        while(change>0){
            if(change>=500){
                tmp = change/500;
                cnt += tmp;
                change = change%500;
            } else if (change>=100) {
                tmp = change/100;
                cnt += tmp;
                change = change%100;
            } else if (change>=50) {
                tmp = change/50;
                cnt += tmp;
                change = change%50;
            } else if (change>=10) {
                tmp = change/10;
                cnt += tmp;
                change = change%10;
            }
            else if (change>=5) {
                tmp = change/5;
                cnt += tmp;
                change = change%5;
            }
            else {
                tmp = change/1;
                cnt += tmp;
                change = change%1;
            }
        }

        System.out.println(cnt);

    }
}
