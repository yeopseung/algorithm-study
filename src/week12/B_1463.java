package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1463번
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 */

public class B_1463
{
    final static int MAX = 10000000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X;
        int[] dp;

        // 정수 X 입력
        X = Integer.parseInt(br.readLine());

        // 각 숫자들의 최소 연산을 저장할 배열
        dp = new int[X+1];

        // 초기값 설정
        dp[1] = 0;

        // 동적 프로그래밍, 범위는 2~X 까지
        for(int i=2; i<=X; i++)
        {
            int a = MAX, b = MAX, c = MAX;

            // 1. i가 3으로 나누어 떨어지면, 3으로 나눈다.
            if(i%3 == 0)
            {
                // i를 3으로 나눴을 때 해당하는 숫자의 최소 연산 횟수 +1
                a = dp[i/3] + 1;
            }

            // 2. i가 2로 나누어 떨어지면, 2로 나눈다.
            if(i%2 == 0)
            {
                // i를 2로 나눴을 때 해당하는 숫자의 최소 연산 횟수 +1
                b = dp[i/2] + 1;
            }

            // 3. 1을 뺀다.
            // i에서 1을 뺐을 때 해당하는 숫자의 최소 연산 횟수 +1
            c = dp[i-1] +1;

            // 1,2,3 번 중 연산 횟수가 최소인것을 선택
            dp[i] = Math.min(a, Math.min(b,c));

        }

        // 결과 출력
        System.out.println(dp[X]);

    }

}
