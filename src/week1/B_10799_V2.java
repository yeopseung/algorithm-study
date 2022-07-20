package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
    백준 10799번 쇠막대기

    '()' : 레이저
    '( ~~~ )' : 쇠막대기

    스택을 이용하여 구현

 */
public class B_10799_V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input;
        int result=0;

        //예제 입력
        input = br.readLine();


        //input 하나씩 읽어 처리
        for(int i=0; i< input.length(); i++)
        {
            // '('일 경우 : '('를 스택에 push
            if(input.charAt(i) == '(')
            {
                stack.push('(');
                continue;
            }
            // ')'일 경우
            else if(input.charAt(i) == ')')
            {
                // stack 에서 '(' pop
                stack.pop();

                // '()' 레이저일 경우
                if(input.charAt(i-1) == '(')
                {
                    // stack.size()가 레이저가 있는 쇠막대기의 개수이므로 더해줌
                    result += stack.size();
                }
                // 쇠막대기일 경우
                else
                    result++;
            }
        }

        System.out.println(result);
    }
}

