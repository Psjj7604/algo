import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String st = br.readLine();
            if(st.equals("."))
                break;
            Stack<Character> stack = new Stack<>();
            char tmp;
            for (int i = 0; i < st.length(); i++) {

                if (st.charAt(i) == '[')
                    stack.push(st.charAt(i));
                else if (st.charAt(i) == '(')
                    stack.push(st.charAt(i));
                else if (st.charAt(i) == ')') {
                    if (!stack.empty()) {
                        tmp = stack.pop();
                        if (tmp == '(') {
                            continue;
                        } else {
                            stack.push(tmp);
                            System.out.println("no");
                            break;
                        }
                    } else {
                        System.out.println("no");
                        break;
                    }
                }
                else if (st.charAt(i) == ']') {
                    if (!stack.empty()) {
                        tmp = stack.pop();
                        if (tmp == '[') {
                            continue;
                        } else {
                            stack.push(tmp);
                            System.out.println("no");
                            break;
                        }
                    } else {
                        System.out.println("no");
                        break;
                    }
                }

                if(i==st.length()-1) {
                    if(stack.empty())
                        System.out.println("yes");
                    else
                        System.out.println("no");
                }

            }

        }
    }
}
