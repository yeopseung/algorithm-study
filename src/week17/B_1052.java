package week17;

import java.util.Scanner;

public class B_1052
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N, K, result;

        // N: 물병의 개수
        N = sc.nextInt();
        // K: 만들어야하는 물병의 개수
        K = sc.nextInt();

        result = 0;
        while(true)
        {
            int num = N;
            int cnt =0;

            while(num > 0)
            {
                if((num & 1) == 1)
                    cnt++;

                num = num >> 1;
            }

            if(cnt <= K)
            {
                System.out.println(result);
                break;
            }

            N++;
            result++;
        }
    }
}
