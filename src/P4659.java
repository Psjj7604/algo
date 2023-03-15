import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};

        while (true){
            String input = br.readLine();
            if(input.equals("end"))
                break;
            int vowelCnt=0;
            int consonantCnt=0;

            boolean hasVowel = false;
            boolean access = true;

            for (int i = 0; i <input.length() ; i++) {
                char index = input.charAt(i);
                boolean isVowel = false;
    
                for (int j = 0; j < vowel.length; j++) {    //현재 글자가 모음인지 확인
                    if(index==vowel[j]){
                        hasVowel = true;
                        isVowel = true;
                        vowelCnt++;
                        consonantCnt=0;
                        break;
                    }
                }
                if(!isVowel){
                    consonantCnt++;
                    vowelCnt=0;
                }

                if(i>0){
                    if((input.charAt(i-1) == index)  && (index!='e' && index!='o')){
                        access = false;
                        System.out.println("<"+input+"> is not acceptable.");
                        break;
                    }
                }

                if(i==input.length()-1){
                    if(hasVowel==false){
                        access = false;
                        System.out.println("<"+input+"> is not acceptable.");
                        break;
                    }
                }


                if(consonantCnt==3 || vowelCnt==3){
                    access = false;
                    System.out.println("<"+input+"> is not acceptable.");
                    break;
                }
            }
            if(access==true)
                System.out.println("<"+input+"> is acceptable.");

        }


    }
}
