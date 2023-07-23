import java.util.Scanner;
import java.util.Stack;

public class Main {
    static StringBuffer sb = new StringBuffer();
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        char operator;

        Scanner sc = new Scanner(System.in);
        String str;



        str = sc.nextLine();

        for(int i=0; i<str.length(); i++)
        {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
            {
                sb.append(str.charAt(i));
            }
            else
            {
                operator = str.charAt(i);
                if(stack.isEmpty())
                    stack.push(operator);
                else
                {
                    
                    switch (operator)
                    {
                        case '+':
                        case '-':
                            while(!stack.isEmpty())
                            {
                                //operator 기준 stack.peek()와 비교하여 연산자 우선순위가 같거나 높을 경우: '+' or '-' or '*' or '/'
                                if(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')
                                {
                                    sb.append(stack.pop());
                                }
                                else
                                    break;
                            }
                            stack.push(operator);
                            break;

                        case '*':
                        case '/':
                            while(!stack.isEmpty())
                            {
                                //operator 기준 stack.peek()와 비교하여 연산자 우선순위가 같을 경우 '*' or '/'
                                if(stack.peek() == '*' || stack.peek() == '/')
                                {
                                    sb.append(stack.pop());
                                }
                                else
                                    break;
                            }
                            stack.push(operator);
                            break;

                        case '(':
                            stack.push(operator);
                            break;
                        case ')':
                            stack_append();
                            break;
                    }
                }

            }
        }


        stack_append();
        System.out.println(sb);
    }

    static void stack_append()
    {

        while(!stack.isEmpty())
        {
            //operator 가 ')'이었을 경우 '(' 까지 pop -> append
            if(stack.peek() == '(')
            {
                stack.pop();
                break;
            }

            sb.append(stack.pop());
        }

    }
}
