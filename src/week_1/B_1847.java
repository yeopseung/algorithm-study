package week_1;

import java.util.Scanner;
import java.util.Stack;

public class B_1847 {
    public static void main(String[] args) {
        int n, num, start = 1, top = 1;

        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i=0; i<n ; i++)
        {
            num = sc.nextInt();

            if(num >= top)
            {
                for(int j=start; j<=num; j++)
                {
                    stack.push(j);
                    sb.append("+\n");


                }
                stack.pop();
                sb.append("-\n");
                if(!stack.isEmpty())
                    top = stack.peek();
//                printStack(stack);
                if(start <= num) {
                    start = num + 1;
                }
            }
            else
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

    }

//    public static void printStack(Stack<Integer> stack)
//    {
//        for(int i=0; i<stack.size(); i++)
//        {
//            System.out.println(stack.get(i));
//        }
//    }
}
