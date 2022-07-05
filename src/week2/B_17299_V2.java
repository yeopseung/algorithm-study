package week2;


import java.util.Scanner;
import java.util.Stack;

public class B_17299_V2 {
    public static void main(String[] args) {
        int N, num;
        int[] list, count;


        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        N = sc.nextInt();
        list = new int[N];
        count = new int[1000001];
        for(int i=0; i<N; i++)
        {
            num = sc.nextInt();
            list[i] = num;
            count[num]++;

        }

        stack.push(0);
        for(int i=1; i<N; i++)
        {

            while(!stack.isEmpty() && count[list[stack.peek()]] < count[list[i]])
            {
                list[stack.pop()] = list[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            list[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++)
        {
            sb.append(list[i] + " ");
        }

        System.out.println(sb);
    }
}
