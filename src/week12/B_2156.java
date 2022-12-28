package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int[] wine, dp;

        // N: 와인잔의 개수, 입력
        N = Integer.parseInt(br.readLine());

        // wine[]: 각 와인잔에 들어있는 와인 양, 입력
        wine = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // dp[]: i번째 와인잔에서 와인의 최대 양
        dp = new int[N+1];


        // 초기값 설정
        // 1번의 최대 양 -> 1번 와인잔의 양
        dp[1] = wine[1];
        // 2번의 최대 양 -> 1,2번 와인잔의 양
        if(N>=2)
        {
            dp[2] = wine[1] + wine[2];
        }
        // 3번의 최대 양 -> 1,2,3번 중 양이 많은 2개
        if(N>=3)
        {
            dp[3] = Math.max(wine[1]+wine[2],Math.max(wine[2]+wine[3],wine[1]+wine[3]));
        }

        // 4번 이상의 최대 양
        // KeyPoint: 이전에 계산한 값들은 3개 이상 연속되는 것이 없다는 것을 보장함, 최대 2개 연속
        for(int i=4; i<=N; i++)
        {
            // 1. i번 와인잔을 고르지 않았을 경우
            // 2. i번 와인잔을 고르고, i-2번 와인잔을 골랐을 경우
            //    -> i번과 i-2번은 연속되지 않았으며 i-2번은 KeyPoint 를 보장함
            // 3. i번 와인잔을 고르고, i-1번, i-3번을 골랐을 경우
            //    -> i번과 i-2번이 연속되지만 3번의 연속을 넘지 않았으며, i-3번은 KeyPoint 를 보장함
            dp[i] = Math.max(dp[i-1], Math.max(wine[i] + dp[i-2], wine[i] + wine[i-1] + dp[i-3]));
        }


        System.out.println(dp[N]);
    }
}
