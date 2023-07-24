import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;
        int[] num, dp;

        // N: 수열의 크기 / 입력
        N = Integer.parseInt(br.readLine());

        // num[]: 수열의 숫자들을 저장하는 배열 / 입력
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]: i번째 숫자가 만들 수 있는 가장 큰 수
        dp = new int[N];



        // 초기값 설정
        dp[0] = num[0];
        for(int i=1; i<N; i++)
        {
            // 이전 값이 음수면 안받고 양수면 받음
            if(dp[i-1] > 0)
                dp[i] = dp[i-1] + num[i];
            else
                dp[i] = num[i];
        }

        // dp 배열 오름차순 정렬 -> 연속합의 최댓값은 N-1 번에
        Arrays.sort(dp);

        // 결과 출력
        System.out.println(dp[N-1]);

    }
}
