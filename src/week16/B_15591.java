package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_15591
{
    static int N, Q, K, V;
    static int[][] graph;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        // N: 동영상 개수
        N = Integer.parseInt(st.nextToken());
        // Q: 질문의 개수
        Q = Integer.parseInt(st.nextToken());

        // graph[][]: 각 정점간의 cost 를 저장하는 배열
        graph = new int[N+1][N+1];
        for(int i=0; i<=N; i++)
            Arrays.fill(graph[i], Integer.MAX_VALUE);

        // (N-1)개의 주어지는 간선의 정보
        int start, end, cost;
        for(int i=1; i<=N-1; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[start][end] = cost;
            graph[end][start] = cost;
        }


//        for(int i=1; i<=N; i++)
//        {
//            for(int j=1; j<=N; j++)
//            {
//                System.out.print(graph[i][j]+"  ");
//            }
//            System.out.println();
//        }

        for(int i=1; i<=Q; i++)
        {
            int result = 0;
            st = new StringTokenizer(br.readLine());

            // K: K 값 이상인 동영상을 선택해야함
            K = Integer.parseInt(st.nextToken());
            // V: V 번째 동영상에서
            V = Integer.parseInt(st.nextToken());

            for(int j=1; j<=N; j++)
            {
                if(V==j)
                    continue;

                if(graph[V][j] == Integer.MAX_VALUE)
                    bfs(V,j);

                if(graph[V][j] >= K)
                    result++;
            }

            System.out.println(result);
        }

    }

    private static void bfs(int start, int end)
    {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.add(new Node(start,Integer.MAX_VALUE));
        visited[start] = true;

        while(!queue.isEmpty())
        {
            Node cur = queue.poll();

            if(cur.index == end)
            {
                if(graph[start][end] > cur.cost)
                {
                    graph[start][end] = cur.cost;
                    graph[end][start] = cur.cost;
                }
            }

            for(int i=1; i<=N; i++)
            {
                if(cur.index == i)
                    continue;

                if(graph[cur.index][i] != Integer.MAX_VALUE && !visited[i])
                {
                    queue.add(new Node(i,Math.min(cur.cost, graph[cur.index][i])));
                    visited[i] = true;
                }
            }
        }

    }

    static class Node
    {
        int index, cost;

        Node(int index, int cost)
        {
            this.index = index;
            this.cost = cost;
        }
    }
}
