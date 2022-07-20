package week1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class B_2212 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> center = new ArrayList<>();
        Stack<Integer> stack = new java.util.Stack<>();


        int N, K, sensor, result=0;

        //센서개수, 집중국 개수 입력
        N = sc.nextInt();
        K = sc.nextInt();

        //센서 위치 입력 및 정렬 +중복 제외
        for(int i=0; i<N; i++)
        {
            center.add(sc.nextInt());
        }
        Collections.sort(center);

        int before, diff;
        before = center.get(0);
        for(int i=1; i<N; i++)
        {
            diff = center.get(i)-before;
            if(diff != 0)
            {
                stack.push(diff);
                before = center.get(i);
            }
        }
        Collections.sort(stack);

        for(int i=0; i<K-1; i++)
        {
            if(!stack.isEmpty())
                stack.pop();
        }

        while(!stack.isEmpty())
        {
            result += stack.pop();
        }

        System.out.println(result);

    }
}


