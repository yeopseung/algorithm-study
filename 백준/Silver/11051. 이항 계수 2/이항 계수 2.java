import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static final int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, K;
        long[][] dp;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new long[N+1][K+1];

        System.out.println(combination(dp, N, K));

        br.close();
    }

    private static long combination(long[][] dp, int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        if(n == r || r == 0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = (combination(dp,n-1, r-1) + combination(dp,n-1, r)) % DIV;
    }

}