
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph;
        int N, M, X, result;
        int[] dist, visit;

        st = new StringTokenizer(br.readLine());
        // N: 마을(정점)의 수
        N = Integer.parseInt(st.nextToken());
        // M: 도로(간선)의 수
        M = Integer.parseInt(st.nextToken());
        // X: 파티가 열리는 장소 (도착지)
        X = Integer.parseInt(st.nextToken());


        // 간선의 정보를 저장할 ArrayList 선언
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++)
        {
            graph.add(new ArrayList<>());
        }


        // 간선 정보 입력
        int start, end, cost;
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }


        // X에서 각각의 마을로 가는데 드는 최소비용
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Node(X,0));
        dist[X] = 0;

        while(!pq.isEmpty())
        {
            Node curNode = pq.poll();

            if(dist[curNode.index] < curNode.cost)
                continue;

            for(int i=0; i<graph.get(curNode.index).size(); i++)
            {
                Node nextNode = graph.get(curNode.index).get(i);

                if(dist[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }


        // 각 마을에서 K로 가는데 드는 최소비용
        result = Integer.MIN_VALUE;
        for(int k=1; k<=N; k++)
        {
            visit = new int[N+1];
            Arrays.fill(visit, Integer.MAX_VALUE);

            pq.clear();
            pq.add(new Node(k,0));
            visit[k] = 0;

            while(!pq.isEmpty())
            {
                Node curNode = pq.poll();

                if(visit[curNode.index] < curNode.cost)
                    continue;

                for(int i=0; i<graph.get(curNode.index).size(); i++)
                {
                    Node nextNode = graph.get(curNode.index).get(i);

                    if(visit[nextNode.index] > nextNode.cost + curNode.cost)
                    {
                        visit[nextNode.index] = nextNode.cost + curNode.cost;
                        pq.add(new Node(nextNode.index, visit[nextNode.index]));
                    }
                }
            }

            result = Math.max(result, visit[X] + dist[k]);
           
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
