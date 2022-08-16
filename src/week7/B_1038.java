package week7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1038 {
    public static void main(String[] args) {
        int N, count = 1;
        long cut;

        Queue<Long> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();

        //0~9번째 예외처리
        if(0<=N && N <= 9)
        {
            System.out.println(N);
            return;
        }


        //초기 queue 설정
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


            //마지막수 split
            cut = num % 10;
            for(long i = 0 ; i < cut; i++)
            {
                //마지막수 보다 작은 수를 붙여서 queue 에 add
                queue.add((num*10)+i);
            }

            //몇번째인지 count
            count++;
        }

        //1022번째 수 : 9876543210
        //위의 수가 감소하는 수의 끝임
        //1022보다 큰 N 번째는 없으므로 -1 출력
        System.out.println(-1);
        return;
    }

}
