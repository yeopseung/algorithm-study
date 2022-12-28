package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_24416
{
    static int fib_cnt;
    static int fibonacci_cnt;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());

        fibonacci_cnt = 0;

        fib_cnt = fib(N);
        fibonacci(N);

        System.out.println(fib_cnt+" "+fibonacci_cnt);
    }

    private static int fib(int N)
    {
        if(N==1 || N==2)
            return 1;
        else
            return fib(N-1) + fib(N-2);
    }

    private static int fibonacci(int N)
    {

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        fibonacci_cnt++;

        for(int i=3; i<N; i++)
        {
            fibonacci_cnt++;
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}
