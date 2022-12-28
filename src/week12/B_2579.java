package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        long[] dp, score;


        // N : 계단의 수, 입력
        N = Integer.parseInt(br.readLine());

        // score[] : 각 계단의 점수 배열, 입력
        score = new long[N+1];
        for(int i=1; i<=N; i++)
        {
            score[i] = Integer.parseInt(br.readLine());
        }

        // dp[] : 각 층 수 마다 최대 점수를 저장할 배열
        dp = new long[N+1];

        // 초기값 설정 (시작점 값)
        score[0] = 0;
        dp[0] = 0;
        dp[1] = score[1];


        if (N>1)
        {
            dp[2] = score[1] + score[2];
            if (N >= 3)
            {
                dp[3] = Math.max(score[1], score[2]) + score[3];
                if(N >= 4)
                {
                    for(int i=4; i<=N; i++)
                    {
                        dp[i] = Math.max((dp[i-3] + score[i-1]), dp[i-2]) + score[i];
                    }
                }
            }
        }

        //결과 출력
        System.out.println(dp[N]);
    }
}
