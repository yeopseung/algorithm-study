package week1;

import java.util.Scanner;
import java.util.Stack;

public class B_9012 {
    public static void main(String[] args) {
        int T, j;
        String str;
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();


        T = Integer.parseInt(sc.nextLine());

        for(int i=0; i< T; i++)
        {
            str = sc.nextLine();
            stack.clear();
            for(j=0; j< str.length() ; j++)
            {
                if(str.charAt(j) == '(')
                {
                    stack.push('(');
                }
                else if(str.charAt(j) == ')')
                {
                    if(stack.isEmpty())
                    {
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty() && j==str.length())
            {
                System.out.println("YES");
            }
            else
                System.out.println("NO");


        }




    }
}
