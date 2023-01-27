
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
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

        // graph: 각 정점간의 cost 를 저장하는 배열
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

            for(Node next: graph.get(cur))
            {
                if(!visited[next.index])
                {
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
