package week_1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_17413 {
    static Stack<Character> stack = new Stack<>();
    static StringBuffer result = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str, tag;
        int i, start, end;

        str = br.readLine();
        for(i=0; i<str.length(); i++)
        {

            // ' ' : stack 을 pop 하여 reverse 된 문자열 획득
            if(str.charAt(i) == ' ')
            {
                addString();
                result.append(' ');
            }
            // '<' : '>'의 index 를 찾아 <tag> 문자열 획득
            else if(str.charAt(i)== '<')
            {
                // '<' 이전 문자열 처리
                addString();

                // '<', '>' 짝이 맞을 경우
                if(str.contains(">"))
                {
                    start = i;
                    while(str.charAt(i) != '>')
                    {
                        i++;
                    }
                    tag = str.substring(start, i+1);
                    result.append(tag);
                }
                // 아닐 경우
                else
                {
                    stack.push(str.charAt(i));
                }
            }
            //그 외의 문자는 stack 에 저장
            else
            {
                stack.push(str.charAt(i));

                //마지막 문장 처리
                if(i == str.length()-1)
                {
                   addString();
                }
            }
        }
        System.out.print(result);
    }

    public static void addString()
    {
        while(!stack.isEmpty())
        {
            result.append(stack.pop());
        }
    }
}
