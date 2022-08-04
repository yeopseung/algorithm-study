package week5;

import java.util.Arrays;
import java.util.Scanner;

public class B_2133 {
    static int N;
    static int[] list = new int[31];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Arrays.fill(list,-1);
        System.out.println(dp(N));
    }

    static int dp(int num)
    {
        int result, sum =0;

        //홀수의 경우 가짓수가 없기 때문에 0 반환
        if((num%2) != 0)
            return 0;

        //초기값 설정
        if(num == 2)
            return 3;
        if(num == 4)
            return 11;

        if(list[num] != -1)
            return list[num];



        sum = calc(num-4);



        result = (dp(num-2) * dp(2)) +  2 *sum +2;
        list[num] = result;
        return result;

    }

    static int calc(int num)
    {
        int result =0;
        while(num > 0)
        {
            result += dp(num);
            num -= -2;
        }
        return result;
    }
}
