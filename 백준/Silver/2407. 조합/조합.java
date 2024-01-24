import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new BigInteger[n + 1][m + 1];
        for (BigInteger[] row : dp) {
            Arrays.fill(row, BigInteger.ZERO);
        }

        System.out.println(combination(n, m));
    }

    private static BigInteger combination(int n, int m) {
        if (dp[n][m].compareTo(BigInteger.ZERO) > 0) {
            return dp[n][m];
        }

        if (n == m || m == 0) {
            return dp[n][m] = BigInteger.ONE;
        }
        else{
            return dp[n][m] = combination(n - 1, m - 1).add(combination(n - 1, m));
        }
    }
}