
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    private static final int INF = 200000000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph;
        int N, E, V1, V2;
        long result;
        int[] dist, dist_v1, dist_v2;

        st = new StringTokenizer(br.readLine());
        // N: 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // E: 간선의 개수
        E = Integer.parseInt(st.nextToken());

        // 간선의 정보를 담을 ArrayList 선언
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++)
            graph.add(new ArrayList<>());

        // 간선 정보 입력
        int start, end, cost;
        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        // V1: 꼭 지나가야하는 정점 1
        V1 = Integer.parseInt(st.nextToken());
        // V2: 꼭 지나가야하는 정점 2
        V2 = Integer.parseInt(st.nextToken());


        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });



        // 1번 출발 최소비용 저장 배열
        dist = new int[N+1];
        Arrays.fill(dist,INF);

        pq.clear();
        pq.add(new Node(1,0));
        dist[1] = 0;

        while(!pq.isEmpty())
        {
            Node curNode = pq.poll();

            if(dist[curNode.index] < curNode.cost)
                continue;

            for(int i=0; i<graph.get(curNode.index).size();i++)
            {
                Node nextNode = graph.get(curNode.index).get(i);

                if(dist[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist[nextNode.index]));
                }

            }
        }

        // V1번 출발 최소비용 저장 배열
        dist_v1 = new int[N+1];
        Arrays.fill(dist_v1, INF);

        pq.clear();
        pq.add(new Node(V1,0));
        dist_v1[V1] = 0;

        while(!pq.isEmpty())
        {
            Node curNode = pq.poll();

            if(dist_v1[curNode.index] < curNode.cost)
                continue;

            for(int i=0; i<graph.get(curNode.index).size();i++)
            {
                Node nextNode = graph.get(curNode.index).get(i);

                if(dist_v1[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist_v1[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist_v1[nextNode.index]));
                }

            }
        }

        // V2번 출발 최소비용 저장 배열
        dist_v2 = new int[N+1];
        Arrays.fill(dist_v2, INF);

        pq.clear();
        pq.add(new Node(V2,0));
        dist_v2[V2] = 0;

        while(!pq.isEmpty())
        {
            Node curNode = pq.poll();

            if(dist_v2[curNode.index] < curNode.cost)
                continue;

            for(int i=0; i<graph.get(curNode.index).size();i++)
            {
                Node nextNode = graph.get(curNode.index).get(i);

                if(dist_v2[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist_v2[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist_v2[nextNode.index]));
                }

            }
        }


        // 1-V1-V2-N , 1-V2-V2-N 둘 중 최소 비용을 결과로 출력
        result = Math.min(dist[V1]+dist_v1[V2]+dist_v2[N],dist[V2]+dist_v2[V1]+dist_v1[N]);
        if(result >= INF)
            result = -1;
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
