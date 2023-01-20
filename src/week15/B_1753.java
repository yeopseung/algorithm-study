package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1753
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<ArrayList<Node>> graph;
        int V, E, K;
        int[] dist;

        st = new StringTokenizer(br.readLine());
        // V: 정점의 개수
        V = Integer.parseInt(st.nextToken());
        // E: 간선의 개수
        E = Integer.parseInt(st.nextToken());
        // K: 시작 정점 번호
        K = Integer.parseInt(br.readLine());

        // 각 정점마다 간선의 정보를 담기 위한 ArrayList 선언
        // 0~V (사실 0은 안쓰는데 어쩔 수 없음)
        graph = new ArrayList<>();
        for(int i=0; i<=V; i++)
        {
            graph.add(new ArrayList<>());
        }

        // 각 정점마다 간선의 정보를 담음
        int start, end, cost;
        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            // 단방향일 경우
            // start 번 정점에서 end 번 정점으로 이동하는데 드는 비용은 cost 이다.
            graph.get(start).add(new Node(end,cost));

            // 양방향일 경우 해당 내용 추가
            //graph.get(end).add(new Node(start,cost));
        }

        // dist[]: 각 정점으로 가는데 드는 최소비용을 저장하는 배열
        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // 우선순위 큐를 이용한 다익스트라 알고리즘
        // 비용이 가장 적은 순으로 추출
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작 정점 K부터 비용 0으로 시작
        pq.add(new Node(K,0));
        // 시작 정점 방문 표시
        dist[K] = 0;

        while(!pq.isEmpty())
        {
            Node curNode = pq.poll();

            // 꺼낸 노드 = 현재 최소 비용을 갖는 노드.
            // 꺼낸 노드의 비용이 최소 비용을 기록하는 dist 배열의 내용보다 크다면 고려할 필요가 없으므로 스킵
            if(dist[curNode.index] < curNode.cost)
                continue;

            // 꺼낸 노드와 간선이 연결되어 있는 노드들의 최소비용을 계산하고 갱신 및 큐에 추가
            for(int i=0; i<graph.get(curNode.index).size(); i++)
            {
                // 다음으로 방문하려는 노드
                Node nextNode = graph.get(curNode.index).get(i);

                // dist 배열에 저장된 비용보다 현재 노드에서 다음 노드를 방문하는 비용이 더 작은 경우 갱신 및 큐에 추가
                if(dist[nextNode.index] > nextNode.cost + curNode.cost)
                {
                    dist[nextNode.index] = nextNode.cost + curNode.cost;
                    pq.add(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }

        // 결과 출력
        for(int i=1; i<=V; i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    // index 로 이동하는데 드는 cost 를 저장하는 class
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
