package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();


        long N, A,B, result =0;


        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            priorityQueue.add(Long.parseLong(br.readLine()));
        }



        while(priorityQueue.size()>0)
        {

            if(priorityQueue.size() == 1)
            {
                break;
            }

            A = priorityQueue.poll();
            B = priorityQueue.poll();

            result += A+B;
            priorityQueue.add(A+B);
        }
        System.out.println(result);

    }
}
