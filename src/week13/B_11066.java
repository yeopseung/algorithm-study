package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  이미 정해져 있는 경우 (초기값)
 *      - 파일이 A,B 2개일 때 -> A+B 가 최소
 *      - 파일이 A,B,C 3개일 때 -> (A+B)+C or A+(B+C)
 *
 *  중복되는 부분
 *      - 파일이 A,B,C,D 4개일 때 -> A,B,C 를 합치는 방법에 이전의 경우의 수가 사용 -> 중복되는 부분 문제 존재 -> DP
 *
 *  문제에 나와있듯이 파일을 계속 2개씩 합쳐서 최종적인 완성본을 만들어가는 것임
 *  즉, 파일을 합치는 경우는 전체 파일을 항상 2부분으로 나눈 후 각 부분을 합치는 것과 같음
 *
 *  메모이제이션 적용
 *      - 전체 파일은 항상 좌측부분과 우측부분, 2부분으로 나뉘어짐
 *      - 이때 저장하는 방식은 좌측 부분과 우측 부분의 [시작점][끝점]을 좌표로 배열에 저장하면 가능
 *
 *  예시) A,B,C 파일 3개일 때 최솟값
 *      - DP[1][1] + DP[2][3] + (file[1]+file[2]+file[3])
 *          - A~A의 최소비용 + B~C의 최소비용 + A~C 누적합
 *      - DP[1][2] + DP[3][3] + (file[1]+file[2]+file[3])
 *          - A~B의 최소비용 + C~C의 최소비용 + A~C 누적합
 *      - (file[1]+file[2]+file[3]) == sum[3]
 */

public class B_11066
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;


        int T, K;
        int[] file;
        int[] sum;
        int[][] dp;

        // T: 테스트 개수
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++)
        {
            // K: 소설을 구성하는 파일 개수
            K = Integer.parseInt(br.readLine());

            // file[]: 각 파일의 크기를 저장하는 배열
            file = new int[K+1];
            // sum[]:  각 파일들의 크기를 누적합 해놓은 배열
            sum = new int[K+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=K; i++)
            {
                file[i] = Integer.parseInt(st.nextToken());
                // 효율적인 계산을 위해 누적합을 미리 구해놓음
                sum[i] = sum[i-1] + file[i];
            }

            // dp[i][j]: i~j 까지를 더했을 때 최소 비용을 저장하는 배열
            dp = new int[K+1][K+1];
            // 몇개씩 묶을 것 인지
            for(int i=1; i<=K; i++)
            {
                // 어디서부터 묶을 것 인지, start 는 시작점
                for(int start=1; start+i <=K; start++)
                {
                    // end 는 끝점
                    int end = start+i;
                    // 결과 저장
                    dp[start][end] = Integer.MAX_VALUE;

                    // 묶여진 곳 내에서 어떻게 두개로 나눌것 인지
                    for(int divide=start; divide < end; divide++)
                    {
                        // 묶은 범위 내에서 최소 비용 -> 두개로 나눈것들 중 최소 비용
                        dp[start][end] = Math.min(dp[start][end], dp[start][divide] + dp[divide + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }

            // 결과 저장
            sb.append(dp[1][K]+"\n");

        }

        // 결과 출력
        System.out.println(sb);
    }
}
