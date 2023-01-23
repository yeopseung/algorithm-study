package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1916
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph;
        int N, M , X, Y;
        int[] dist;

        // N: 도시(정점)의 개수
        N = Integer.parseInt(br.readLine());

        // M: 버스(간선)의 개수
        M = Integer.parseInt(br.readLine());

        // 각 도시의 간선 정보를 저장할 ArrayList 선언
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

            // 단방향
            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        // X: 출발 도시 번호
        X = Integer.parseInt(st.nextToken());
        // Y: 도착 도시 번호
        Y = Integer.parseInt(st.nextToken());

        // 최소 비용 저장 배열 선언
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 우선순위 큐를 이용하여 현재 최소비용 추출
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작점 설정
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

        System.out.println(dist[Y]);

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
