package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_15591_V2
{
    static int N, Q, K, V;
    static HashMap<Integer, ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        // N: 동영상 개수
        N = Integer.parseInt(st.nextToken());
        // Q: 질문의 개수
        Q = Integer.parseInt(st.nextToken());

        // graph.get(Integer) : 간선 정보를 저장하는 ArrayList
        graph = new HashMap();
        for(int i=1; i<=N; i++)
        {
            graph.put(i,new ArrayList<>());
        }

        // (N-1)개의 주어지는 간선의 정보
        int start, end, cost;
        for(int i=1; i<=N-1; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            // 간선 정보 저장
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        for(int i=1; i<=Q; i++)
        {
            st = new StringTokenizer(br.readLine());

            // K: K 값 이상인 동영상을 선택해야함
            K = Integer.parseInt(st.nextToken());
            // V: V 번째 동영상에서
            V = Integer.parseInt(st.nextToken());

            bfs();
        }

    }

    private static void bfs()
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int result  = 0;

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty())
        {
            int cur = queue.poll();

            // 현재 정점에서 연결된 정점을 순회
            for(Node next: graph.get(cur))
            {
                // 방문하지 않았으며
                if(!visited[next.index])
                {
                    // 비용이 K값 이상인 정점을 다음 방문한 정점으로 지정 (결과 +1)
                    // 비용이 K값 보다 작을 경우 다음 정점에서 그 다음 정점을 방문해도 K 값 보다 비용이 무조건 작을것이므로 방문하지 않음
                    if(next.cost >= K)
                    {
                        result++;
                        visited[next.index] = true;
                        queue.add(next.index);
                    }
                }
            }
        }

        System.out.println(result);
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
