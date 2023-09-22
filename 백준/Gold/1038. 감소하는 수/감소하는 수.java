import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, count = 1;
        long cut;

        Queue<Long> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();

        if(0<=N && N <= 9)
        {
            System.out.println(N);
            return;
        }


        for(long i=1; i<=9;i++)
        {
            queue.add(i);
        }



        while(!queue.isEmpty())
        {
            long num = queue.poll();



            //N번째 감소하는 수를 찾았을 경우 출력 후 종료
            if(count == N)
            {
                System.out.println(num);
                return;
            }


            cut = num % 10;
            for(long i = 0 ; i < cut; i++)
            {
                queue.add((num*10)+i);
            }

            count++;
        }

        System.out.println(-1);
        return;
    }

}
