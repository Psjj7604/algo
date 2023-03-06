import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int index = 0;

        int[][] arr =   {
                        {0,0,0,0,0,0}, //0 a
                        {0,0,1,1,1,1},  //1 b
                        {0,1,0,0,1,1},  //2 c
                        {0,1,1,1,0,0},  //3 d
                        {1,0,0,1,1,0},  //4 e
                        {1,0,1,0,0,1},  //5 f
                        {1,1,0,1,0,1},  //6 g
                        {1,1,1,0,1,0}   //7 h
                        };

        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        String input = br.readLine();
        String[] inputArr = input.split("");

        loop1 :
        for(int i=0; i<N;i++){

            for(int j=0; j<8; j++){
                cnt = 0;
                for(int k=0;k<6;k++){
                    int compareNum = Integer.parseInt(inputArr[(i*6)+k]);
                    if(!(compareNum==arr[j][k])) {
                        cnt++;
                    }
                }
                if(2>cnt){
                    sb.append(alpha[j]);
                    continue loop1;
                }
                else if(j==7 && cnt > 1){
                    sb.setLength(0);
                    sb.append(i + 1);
                    break loop1;
                }
            }

        }

        System.out.println(sb);




    }
}
