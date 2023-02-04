package week17;

import java.util.Scanner;

public class B_1094
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int X, stick, sum, cnt;

        X = sc.nextInt();
        cnt = 1;
        stick = 64;
        sum = 64;

        while(true)
        {
            stick = stick >> 1;

            if(sum == X)
                break;

            if((sum - stick) >= X)
                sum -= stick;
            else
                cnt++;
        }

        System.out.println(cnt);

    }
}
