package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1976
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N,M;
        int[] plan;
        int[][] connect;
        boolean[] visited;

        // N: 도시의 수
        N = Integer.parseInt(br.readLine());

        // M: 여행 계획에 속한 도시들의 수
        M = Integer.parseInt(br.readLine());

        // connect[i][j]: i 도시와 j 도시의 연결 정보, 기준은 i 도시
        connect = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
            {
                connect[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // plan[]: 여행 계획
        plan = new int[M+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++)
        {
            plan[i] = Integer.parseInt(st.nextToken());
        }


        Queue<Route> queue = new LinkedList<>();
        // 여행 계획 첫번째 부터 방문하며 시작
        queue.add(new Route(plan[1]));
        while(!queue.isEmpty())
        {
            Route curRoute = queue.remove();

            // BFS 를 통해 방문 도시 체크
            for(int i=1; i<=N; i++)
            {
                if(i == curRoute.index && !visited[i])
                {
                    visited[i] = true;
                    queue.add(new Route(i));
                }


                if(connect[curRoute.index][i] == 1 && !visited[i])
                {
                   visited[i] = true;
                   queue.add(new Route(i));
                }
            }
        }


        // 여행 계획 첫번째 부터 BFS 순회한 결과를 토대로
        // 여행 계획에 포함되어 있지만 방문하지 않은 도시가 존재할 경우 -> NO 출력 및 종료
        for(int i=1; i<=N; i++)
        {
            if(!visited[i])
            {
                for(int j=1; j<=M; j++)
                {
                    if(plan[j] == i)
                    {
                        System.out.println("NO");
                        return;
                    }

                }
            }
        }

        // 모두 방문했을 경우 -> YES
        System.out.println("YES");

    }

    static class Route
    {
        int index;

        Route(int index)
        {
            this.index = index;
        }
    }
}
