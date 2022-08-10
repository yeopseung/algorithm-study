package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17404 {
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
        //초기값 설정
        if(index == N-1)
        {
            //시작값이랑 마지막값이 같은경우 불가능
            if(color == start)
                return 99999;
            else
                //마지막값 리턴
                return cost[index][color];
        }

        //계산되지 않은 dp 일경우 계산 필요
        if(dp[index][color][start] == 0)
        {
            //R일 경우
            if(color==0)
                //R일때 비용 + 이전에 계산한 G or B 값 중 최소
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,1,start),dp(index+1,2,start));
            //G일 경우
            else if (color == 1)
                //G일때 비용 + 이전에 계산한 R or B 값 중 최소
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,0,start),dp(index+1,2,start));
            //B일 경우
            else if (color == 2)
                //B일때 비용 + 이전에 계산한 R or G 값 중 최소
                dp[index][color][start] = cost[index][color] + Math.min(dp(index+1,0,start),dp(index+1,1,start));
        }

        return dp[index][color][start];
    }
}
