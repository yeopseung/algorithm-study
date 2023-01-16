package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2293
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N, K;
        int[] coins, dp;

        st = new StringTokenizer(br.readLine());
        // N: 동전의 개수
        N = Integer.parseInt(st.nextToken());
        // K: 만들어야할 동전의 합
        K = Integer.parseInt(st.nextToken());

        // coins[]: 동전들의 종류 저장 배열
        coins = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp[i]: i원을 만드는 종류를 저장하는 배열
        dp = new int[K+1];


        // 초기값 설정
        dp[0] = 1;

        for(int i=1; i<=N; i++)
        {
            // x원을 가지고 x원 아래의 값을 만들 수 없음
            // ex) 2원으로 1원을 만들 수 없음
            for(int j=coins[i]; j<=K; j++)
            {
                // j원을 만들기 위해서는  j-coins[i] 원을 만드는 가짓수에 더해야함
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        for(int i=1; i<=K;i++)
        {
            System.out.print(dp[i]+"  ");
        }
        System.out.println();

        System.out.println(dp[K]);


    }
}
