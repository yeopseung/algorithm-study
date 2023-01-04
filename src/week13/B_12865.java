package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12865
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, K;
        int[] W, V;
        int[][] dp;

        // N: 물품의 수
        // K: 가방의 최대 무게
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // W[]: 물품의 무게 저장 배열
        // V[]: 물품의 가치 저장 배열
        W = new int[N+1];
        V = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }


        // dp[i][j]
        // i : i번째 아이템
        // j : 가방의 용량 j
        // -> i번째 물건을 넣거나 안넣었을 때 j 용량에서의 최대 이익을 저장
        dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=K; j++)
            {
                if(W[i] > j)
                {
                    // i번째 보석을 배낭에 넣지 않았을 경우
                    // 1. i-1번째 보석을 넣을지 말지 선택한 뒤의 j 무게를 가지는 배낭의 최적값
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    // i번째 보석을 배낭에 넣을 경우
                    // 1. i-1번째 보석을 넣을지 말지 선택한 뒤의 j 무게를 가지는 배낭의 최적값
                    // 2. i-1번째 보석을 넣을지 말지 선택한 뒤의 j - W[i] 무게를 가지는 배낭의 최적값
                    //    i번째 보석을 넣을 것이기 때문에 (j-W[i]) + W[i] -> j 무게가 됌
                    // 1,2 둘 중 가치가 큰 값을 저장
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }

            }
        }

        System.out.println(dp[N][K]);


    }
}
