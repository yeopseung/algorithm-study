import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, K;
        int[][] dp;
        int[][] stones;
        boolean usedK = false;

        // 마지막 N번 산삼

        N = Integer.parseInt(br.readLine());

        stones = new int[N + 1][2];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            stones[i][0] = Integer.parseInt(st.nextToken());
            stones[i][1] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 0;
        if (N == 1) {
            System.out.println(0);
            return;
        }

        dp[2][0] = stones[1][0];
        dp[2][1] = stones[1][0];
        if (N == 2) {
            System.out.println(dp[2][0]);
            return;
        }

        dp[3][0] = Math.min(dp[2][0] + stones[2][0], dp[1][0] + stones[1][1]);
        dp[3][1] = dp[3][0];
        if (N == 3) {
            System.out.println(dp[3][0]);
            return;
        }

        for (int i = 4; i <= N; i++) {
            // K 미사용 (이미 사용했거나 지금 사용하지 않음)

            int a = dp[i - 1][0] + stones[i - 1][0];
            int b = dp[i - 2][0] + stones[i - 2][1];

            dp[i][0] = Math.min(a, b);

            // K 사용
            int x = dp[i - 1][1] + stones[i - 1][0];
            int y = dp[i - 2][1] + stones[i - 2][1];
            int z = dp[i - 3][0] + K;

            dp[i][1] = Math.min(x, Math.min(y, z));

        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}