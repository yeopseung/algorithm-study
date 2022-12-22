package week10;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2164 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            queue.add(i);
        }

        while(!queue.isEmpty())
        {
            if(queue.size() == 1)
            {
                break;
            }

            queue.poll();

            int num = queue.poll();
            queue.add(num);


        }

        int result = queue.peek();
        System.out.println(result);

    }
}
