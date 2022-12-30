import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result;
        String str;
        String[] A, B;
        int[][] dp;

        str = br.readLine();
        A = str.split("");

        str = br.readLine();
        B = str.split("");

        dp = new int[A.length+1][B.length+1];

        for(int i=1; i<=A.length; i++)
        {
            for(int j=1; j<=B.length; j++)
            {
                if(A[i-1].equals(B[j-1]))
                {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[A.length][B.length]);




    }
}
