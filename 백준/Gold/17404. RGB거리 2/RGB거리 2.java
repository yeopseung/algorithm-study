import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] cost;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        N = Integer.parseInt(br.readLine());
        // 0: R / 1: G / 2: B
        cost = new int[N][3];
        dp = new int[N][3][3];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
            {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R or G or B 로 시작한것들 중 가장 최소의 코스트 출력
        System.out.println(Math.min(Math.min(dp(0,0,0),dp(0,1,1)),dp(0,2,2)));
    }

    static int dp(int index,int color, int start)
    {
        if(index == N-1)
        {
            if(color == start)
                return 99999;
            else
                return cost[index][color];
        }


        if(dp[index][color][start] == 0)
        {
            if(color==0)
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,1,start),dp(index+1,2,start));
            else if (color == 1)
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,0,start),dp(index+1,2,start));
            else if (color == 2)
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,0,start),dp(index+1,1,start));
        }

        //System.out.println(dp[index][color][start]);
        return dp[index][color][start];


    }


}
