package week2;

import java.util.Scanner;
import java.util.Stack;

public class B_17298_V2
{
    public static void main(String[] args) {
        int N;
        int[] arr;


        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        N = sc.nextInt();
        arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }



        stack.push(0);
        for (int i = 1; i < N; i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
            {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            arr[stack.pop()] = -1;
        }



        for(int i=0; i<N;i++)
        {
           sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
