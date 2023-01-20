package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_5972
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph;
        int N, M;
        int[] dist;

        st = new StringTokenizer(br.readLine());
        // N: 헛간(정점) 개수
        N = Integer.parseInt(st.nextToken());
        // M: 소들의 길(간선) 개수
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++)
        {
            graph.add(new ArrayList<>());
        }

        int start, end, cost;
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            // 양방향 길
            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));
        }

        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작 정점: 1
        pq.add(new Node(1,0));
        dist[1] = 0;

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

        // 1에서 N까지 이동하는데에 최소 비용
        System.out.println(dist[N]);


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
