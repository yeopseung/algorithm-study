

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    private static int N;
    private static int result;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[][] S;

        // N: 축구하러 모인 인원
        N = Integer.parseInt(br.readLine());

        // S[][]: 능력치 저장
        S = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
            {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++)
        {
            combination(S,new boolean[N+1],1,N,i);
        }

        System.out.println(result);
    }

    // 백트래킹을 이용한 nCr 조합
    private static void combination(int[][] S, boolean[] visited, int start, int n, int r)
    {
        // r 개를 다 뽑았을 때 종료
        if(r==0)
        {
            calcStat(S,visited);
            return;
        }

        for(int i=start; i<=n; i++)
        {
            visited[i] = true;
            combination(S,visited,i+1,n,r-1);
            visited[i] = false;
        }
    }

    private static void calcStat(int[][] S, boolean[] visited)
    {
        int A=0, B=0;

        for(int i=1; i<=N; i++)
        {
            if(visited[i])
            {
                for(int j=1; j<=N; j++)
                {
                    if(i==j)
                        continue;

                    if(visited[j])
                    {
                        A += S[i][j];
                    }
                }
            }
            else
            {
                for(int j=1; j<=N; j++)
                {
                    if(i==j)
                        continue;

                    if(!visited[j])
                    {
                        B += S[i][j];
                    }
                }
            }
        }
        result = Math.min(result, Math.abs(A-B));

    }
}
