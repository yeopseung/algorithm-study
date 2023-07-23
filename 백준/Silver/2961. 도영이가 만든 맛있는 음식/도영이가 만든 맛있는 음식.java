

import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    private static int result;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;
        int[][] taste;
        boolean[] visited = new boolean[10];

        // N: 재료의 개수
        N = Integer.parseInt(br.readLine());

        // taste[][]: 재료의 맛을 저장
        taste = new int[N][2];
        for(int n=0; n<N; n++)
        {
            st = new StringTokenizer(br.readLine());
            taste[n][0] = Integer.parseInt(st.nextToken());
            taste[n][1] = Integer.parseInt(st.nextToken());
        }


        result = Integer.MAX_VALUE;
        // nC1, nC2, ... , nCn
        for(int i=1; i<=N; i++)
        {
            combination(taste,visited,0,N,i);
        }

        System.out.println(result);
    }

    // nCr : 백트래킹을 활용한 조합 함수
    private static void combination(int[][] taste, boolean[] visited, int start, int n, int r)
    {
        // r개를 다 뽑았을 경우 종료
        if(r==0)
        {
            calcTaste(taste, visited);
            return;
        }

        for(int i=start; i<n; i++)
        {
            visited[i] = true;
            combination(taste,visited,i+1,n,r-1);
            visited[i] = false;
        }
    }

    private static void calcTaste(int[][] taste, boolean[] visited)
    {
        int sour = 1, bitter = 0;

        for(int i=0; i< taste.length; i++)
        {
            if(visited[i])
            {
                sour *= taste[i][0];
                bitter += taste[i][1];
            }
        }
        
        result = Math.min(result, Math.abs(sour - bitter));
    }
}
