package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        long result;
        long[][] dp;

        // 길이가 N인 계단 수의 개수를 구해야함
        // N: 계단수의 길이
        N = Integer.parseInt(br.readLine());

        if(N==1)
        {
            System.out.println(9);
            return;
        }

        // dp[i][j] : i 수의 길이, j는 맨 앞의 숫자
        dp = new long[N+1][10];

        // 초기값 설정
        dp[1][0] = 0;
        for(int i=1; i<=9; i++)
        {
            dp[1][i] = 1;
        }


        for(int i=2; i<=N; i++)
        {

            for(int j=0; j<=9; j++)
            {
                if(j == 0)
                {
                    // 맨 앞의 숫자가 0일 경우 이전 자리 숫자의 1만을 더함
                    dp[i][j] = dp[i-1][1] % 1000000000;
                }
                else if(1<=j && j<=8)
                {
                    // 맨 앞의 숫자가 1~8일 경우 이전 자리 숫자의 앞 뒤를 더함
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
                else
                {
                    // 맨 앞의 숫자가 9일 경우 이전 자리 숫자의 8만을 더함
                    dp[i][j] = dp[i-1][8] % 1000000000;
                }
            }
        }

        //결과 값 계산
        result = 0;
        for(int i=0; i<=9; i++)
        {
            result += dp[N][i];
            result %= 1000000000;
        }

        System.out.println(result);


    }
}
