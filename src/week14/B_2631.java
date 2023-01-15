package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2631
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int[] num, dp;

        // 번호 개수
        N = Integer.parseInt(br.readLine());

        // 번호 입력
        num = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            num[i] = Integer.parseInt(br.readLine());
        }

        // LIS 를 구한 뒤 나머지 번호들을 이동하는 것이 옮겨지는 아이의 최소 수임.
        // LIS 저장 배열
        dp = new int[N+1];
        dp[1] = 1;
        for(int i=2; i<=N; i++)
        {
            dp[i] = 1;
            for(int j=i-1; j>=1; j--)
            {
                if(num[i] > num[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        // 오름차순으로 정렬
        Arrays.sort(dp);

        // LIS 는 dp 배열 N번째 원소
        System.out.println(N-dp[N]);



    }
}
