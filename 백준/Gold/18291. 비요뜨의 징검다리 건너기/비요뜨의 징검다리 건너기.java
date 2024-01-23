import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int res;

            if (N <= 2) {
                res = 1;
            } else {
                N -= 2;
                res = (int) pow(N);
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static long pow(int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            long res = pow(n / 2);
            return res * res % MOD;
        } else {
            return 2 * pow(n - 1) % MOD;
        }
    }

}