import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *  KeyPoint:
 *      철거해야할 전선의 최소 개수를 구하는것은 복잡하니 다음과 같은 방식으로 구함
 *      전체 전선의 개수 - 설치할 수 있는 전선의 최대 개수 = 철거해야할 전선의 최소 개수
 *      설치할 수 있는 전선의 최대 개수는 LIS 방식을 통해 구현
 */

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, cnt;
        int[] dp;
        int[][] num;

        // N: 전선 개수
        N = Integer.parseInt(br.readLine());

        // num[i][j] : 전선의 순서쌍 저장 배열 (num[i][0] A 전봇대 연결위치, num[i][1] B 전봇대 연결위치)
        num = new int[N+1][2];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<2; j++)
            {
                num[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        // A 전봇대의 연결위치를 기준으로 전선의 순서쌍들을 정렬
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        // dp[]: 설치할 수 있는 전선의 최대 개수
        dp = new int[N+1];


        // 초기값 설정 (순서쌍이 1개일 때)
        dp[1] = 1;
        for(int i = 2; i <= N; i++)
        {
            dp[i] = 1;
            // i번째 전선을 기준으로 이전의 값들 탐색
            // i번째 전선의 순서쌍에서 B 전봇대에 연결된 위치가
            // j번째 전선의 순서쌍에서 B 전봇대에 연결된 위치보다 값이 커야함
            for(int j = i-1; j >= 1; j--)
            {
                if(num[j][1] < num[i][1])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 설치할 수 있는 전선의 최대 개수 탐색
        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        //전체 전선의 개수 - 설치할 수 있는 전선의 최대 개수 = 철거해야할 전선의 최소 개수
        System.out.println(N - max);

    }

}
