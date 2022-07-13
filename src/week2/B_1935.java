package week2;


import java.util.Scanner;
import java.util.Stack;

public class B_1935 {
    public static void main(String[] args) {
        double N, x,y;
        int[] alphabet = new int[26];
        Stack<Double> stack = new Stack<>();
        String problem;

        Scanner sc  = new Scanner(System.in);

        N = sc.nextInt();

        problem = sc.next();


        for(int i=0; i<problem.length() ; i++)
        {
            //'A' ~ 'Z'일 경우
            if('A' <= problem.charAt(i) && problem.charAt(i) <= 'Z')
            {
                //alphabet 배열에 해당 문자의 값을 저장
                if(alphabet[(int)problem.charAt(i)-65] == 0)
                    alphabet[(int)problem.charAt(i)-65] = sc.nextInt();
                //stack 에 push
                stack.push((double)alphabet[(int)problem.charAt(i)-65]);
            }
            //연산기호일 경우
            else if(!stack.isEmpty())
            {
                //stack 에서 피연산자 두개를 pop 하여 계산
                y = stack.pop();
                x = stack.pop();

//                System.out.println(x +" " + problem.charAt(i)+ " "+y);

                //계산한 내용을 다시 stack 에 push
                switch (problem.charAt(i))
                {
                    case '+':
                        stack.push(x+y);
                        break;
                    case '-':
                        stack.push(x-y);
                        break;
                    case '*':
                        stack.push(x*y);
                        break;
                    case '/':
                        stack.push(x/y);
                        break;
                    default:
                        break;
                }
            }

            if(stack.isEmpty())
                break;
        }

        //결과 출력
        System.out.println(String.format("%.2f",stack.pop()));


    }
}
